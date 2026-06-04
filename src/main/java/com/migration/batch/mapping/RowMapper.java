package com.migration.batch.mapping;

import com.migration.batch.model.Product;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class RowMapper implements RowMapper<Product> {

    @Override
    public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
        Product product = new Product();
        
        product.setProductId(rs.getInt("ProductID"));
        product.setProductName(rs.getString("ProductName"));
        product.setProductCategory(rs.getString("ProductCategory"));
        product.setUnitPrice(rs.getBigDecimal("UnitPrice"));
        product.setQuantityOnHand(rs.getInt("QuantityOnHand"));
        product.setSupplierId(rs.getInt("SupplierID"));
        product.setModifiedDate(rs.getTimestamp("ModifiedDate").toLocalDateTime());
        product.setProductStatus(rs.getString("ProductStatus"));
        
        return product;
    }
}

