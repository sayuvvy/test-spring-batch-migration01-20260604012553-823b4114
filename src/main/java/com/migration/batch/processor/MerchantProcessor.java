package com.migration.batch.processor;

import com.migration.batch.model.Merchant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

/**
 * Processes Merchant items applying business rules and transformations.
 * Implements idempotent, stateless processing suitable for parallel execution.
 */
@Slf4j
@Component
public class MerchantProcessor implements ItemProcessor<Merchant, Merchant> {

    /**
     * Processes a Merchant item applying transformations and validation.
     * 
     * @param item The input Merchant item
     * @return The processed Merchant item, or null to filter out
     */
    @Override
    public Merchant process(Merchant item) throws Exception {
        if (item == null) {
            return null;
        }

        // Validate required fields (idempotent null check)
        if (item.getMerchantId() == null || item.getMerchantName() == null) {
            log.error("Invalid merchant data: missing required fields for MerchantID {}", item.getMerchantId());
            return null; // Filter out invalid items
        }

        // Apply risk scoring based on credit limit and status
        item.setMerchantRiskScore(calculateMerchantRiskScore(item.getCreditLimit(), item.getIsActive()));
        
        // Classify region for aggregation
        item.setRegionGroup(classifyRegion(item.getRegion()));
        
        // Determine active status label
        item.setActiveStatusLabel(determineActiveStatus(item.getIsActive()));

        // Calculate days since registration
        item.setDaysSinceRegistration(calculateDaysSinceRegistration(item.getRegistrationDate()));

        log.debug("Processed merchant: {}", item);
        return item;
    }

    /**
     * Calculates merchant risk score based on credit limit and active status.
     */
    private Double calculateMerchantRiskScore(Double creditLimit, Boolean isActive) {
        if (creditLimit == null) creditLimit = 0.0;
        
        if (creditLimit > 100000 && isActive != null && isActive) return 1.0;
        if (creditLimit > 50000 && isActive != null && isActive) return 2.0;
        if (creditLimit > 10000) return 3.0;
        return isActive != null && !isActive ? 5.0 : 4.0;
    }

    /**
     * Classifies merchants into regional groups.
     */
    private String classifyRegion(String region) {
        if (region == null || region.isEmpty()) return "OTHER";
        return switch (region.toUpperCase()) {
            case "US", "CA", "MX" -> "AMERICAS";
            case "GB", "FR", "DE", "NL" -> "EMEA";
            case "AU", "JP", "IN", "CN" -> "APAC";
            default -> "OTHER";
        };
    }

    /**
     * Determines active status label.
     */
    private String determineActiveStatus(Boolean isActive) {
        return isActive != null && isActive ? "Active" : "Inactive";
    }

    /**
     * Calculates days since merchant registration.
     */
    private Integer calculateDaysSinceRegistration(java.util.Date registrationDate) {
        if (registrationDate == null) return 0;
        
        long daysSinceRegistration = 
            (System.currentTimeMillis() - registrationDate.getTime()) / (24 * 60 * 60 * 1000);
        return Math.max(0, (int) daysSinceRegistration);
    }
}
