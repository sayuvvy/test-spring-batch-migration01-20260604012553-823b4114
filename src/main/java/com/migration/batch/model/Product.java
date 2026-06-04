package com.migration.batch.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Product {
    private Integer productId;
    private String productName;
    private String productCategory;
    private BigDecimal unitPrice;
    private Integer quantityOnHand;
    private Integer supplierId;
    private LocalDateTime modifiedDate;
    private String productStatus;
    
    // Constructors, getters and setters
    public Product() {
    }
    
    public Product(Integer productId, String productName, String productCategory, BigDecimal unitPrice, 
                   Integer quantityOnHand, Integer supplierId, LocalDateTime modifiedDate, String productStatus) {
        this.productId = productId;
        this.productName = productName;
        this.productCategory = productCategory;
        this.unitPrice = unitPrice;
        this.quantityOnHand = quantityOnHand;
        this.supplierId = supplierId;
        this.modifiedDate = modifiedDate;
        this.productStatus = productStatus;
    }
    
    public Integer getProductId() {
        return productId;
    }
    
    public void setProductId(Integer productId) {
        this.productId = productId;
    }
    
    public String getProductName() {
        return productName;
    }
    
    public void setProductName(String productName) {
        this.productName = productName;
    }
    
    public String getProductCategory() {
        return productCategory;
    }
    
    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }
    
    public BigDecimal getUnitPrice() {
        return unitPrice;
    }
    
    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }
    
    public Integer getQuantityOnHand() {
        return quantityOnHand;
    }
    
    public void setQuantityOnHand(Integer quantityOnHand) {
        this.quantityOnHand = quantityOnHand;
    }
    
    public Integer getSupplierId() {
        return supplierId;
    }
    
    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
    }
    
    public LocalDateTime getModifiedDate() {
        return modifiedDate;
    }
    
    public void setModifiedDate(LocalDateTime modifiedDate) {
        this.modifiedDate = modifiedDate;
    }
    
    public String getProductStatus() {
        return productStatus;
    }
    
    public void setProductStatus(String productStatus) {
        this.productStatus = productStatus;
    }
    
    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", productCategory='" + productCategory + '\'' +
                ", unitPrice=" + unitPrice +
                ", quantityOnHand=" + quantityOnHand +
                ", supplierId=" + supplierId +
                ", modifiedDate=" + modifiedDate +
                ", productStatus='" + productStatus + '\'' +
                '}';
    }
}

