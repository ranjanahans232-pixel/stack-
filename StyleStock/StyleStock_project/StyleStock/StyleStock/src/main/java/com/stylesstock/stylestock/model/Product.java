package com.stylesstock.stylestock.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;

@Entity
@Table(name = "products", uniqueConstraints = @UniqueConstraint(columnNames = "sku"))
public class Product {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    @NotBlank private String productName;
    @NotBlank private String sku;
    private String size;
    private String colour;
    @NotNull @DecimalMin("0.00") @Digits(integer = 8, fraction = 2) private BigDecimal unitPrice = BigDecimal.ZERO;
    @ManyToOne(optional = false) private Brand brand;
    @ManyToOne(optional = false) private Category category;
    @ManyToOne(optional = false) private Supplier supplier;

    public Product() {}
    public Long getProductId() { return productId; }
    public void setProductId(Long productId) { this.productId = productId; }
    public String getProductName() { return productName; }
    public void setProductName(String productName) { this.productName = productName; }
    public String getSku() { return sku; }
    public void setSku(String sku) { this.sku = sku; }
    public String getSize() { return size; }
    public void setSize(String size) { this.size = size; }
    public String getColour() { return colour; }
    public void setColour(String colour) { this.colour = colour; }
    public BigDecimal getUnitPrice() { return unitPrice; }
    public void setUnitPrice(BigDecimal unitPrice) { this.unitPrice = unitPrice; }
    public Brand getBrand() { return brand; }
    public void setBrand(Brand brand) { this.brand = brand; }
    public Category getCategory() { return category; }
    public void setCategory(Category category) { this.category = category; }
    public Supplier getSupplier() { return supplier; }
    public void setSupplier(Supplier supplier) { this.supplier = supplier; }
}
