package com.migration.batch.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Merchant {
    private Integer merchantId;
    private String merchantName;
    private BigDecimal creditLimit;
    private String region;
    private Boolean isActive;
    private LocalDateTime registrationDate;
    
    // Constructors, getters and setters
    public Merchant() {
    }
    
    public Merchant(Integer merchantId, String merchantName, BigDecimal creditLimit, String region, 
                    Boolean isActive, LocalDateTime registrationDate) {
        this.merchantId = merchantId;
        this.merchantName = merchantName;
        this.creditLimit = creditLimit;
        this.region = region;
        this.isActive = isActive;
        this.registrationDate = registrationDate;
    }
    
    public Integer getMerchantId() {
        return merchantId;
    }
    
    public void setMerchantId(Integer merchantId) {
        this.merchantId = merchantId;
    }
    
    public String getMerchantName() {
        return merchantName;
    }
    
    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }
    
    public BigDecimal getCreditLimit() {
        return creditLimit;
    }
    
    public void setCreditLimit(BigDecimal creditLimit) {
        this.creditLimit = creditLimit;
    }
    
    public String getRegion() {
        return region;
    }
    
    public void setRegion(String region) {
        this.region = region;
    }
    
    public Boolean getIsActive() {
        return isActive;
    }
    
    public void setIsActive(Boolean active) {
        isActive = active;
    }
    
    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }
    
    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }
    
    @Override
    public String toString() {
        return "Merchant{" +
                "merchantId=" + merchantId +
                ", merchantName='" + merchantName + '\'' +
                ", creditLimit=" + creditLimit +
                ", region='" + region + '\'' +
                ", isActive=" + isActive +
                ", registrationDate=" + registrationDate +
                '}';
    }
}

