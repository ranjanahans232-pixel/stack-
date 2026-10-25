package com.stylesstock.stylestock.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Brand {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long brandId;
    @NotBlank private String brandName;
    private String description;
    private boolean active = true;

    public Brand() {}
    public Brand(String brandName, String description) { this.brandName = brandName; this.description = description; }
    public Long getBrandId() { return brandId; }
    public void setBrandId(Long brandId) { this.brandId = brandId; }
    public String getBrandName() { return brandName; }
    public void setBrandName(String brandName) { this.brandName = brandName; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }
    @Override public String toString() { return brandName; }
}
