package com.migration.batch.reader;

import com.migration.batch.model.Merchant;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * JDBC Cursor Item Reader for Merchant data from SQL Server.
 * Uses streaming approach for large datasets with continuous DB connection.
 */
@Slf4j
@RequiredArgsConstructor
@Component
public class JdbcMerchantItemReader extends JdbcCursorItemReader<Merchant> {

    private final DataSource dataSource;

    /**
     * Initializes the reader with SQL query and row mapper.
     */
    @PostConstruct
    public void initialize() {
        setDataSource(dataSource);
        setSql("SELECT MerchantID, MerchantName, CreditLimit, IsActive, RegistrationDate " +
                "FROM dbo.Merchant " +
                "WHERE RegistrationDate >= :fromDate AND RegistrationDate <= :toDate " +
                "ORDER BY MerchantID");
        setRowMapper(new BeanPropertyRowMapper<>(Merchant.class));
        
        // Configure parameters for dynamic date range
        Map<String, Object> parameterValues = new HashMap<>();
        parameterValues.put("fromDate", "2026-01-01 00:00:00");
        parameterValues.put("toDate", "2026-12-31 23:59:59");
        setParameterValues(parameterValues);
        
        setFetchSize(1000); // Optimize fetch size for streaming
        setMaxRows(10000);  // Limit for initial run
    }
}
