package com.stylesstock.stylestock.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"product_product_id", "centre_centre_id"}))
public class Inventory {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long inventoryId;
    @ManyToOne(optional = false) private Product product;
    @ManyToOne(optional = false) private DistributionCentre centre;
    @Min(0) private int quantity;
    @Min(0) private int reorderLevel = 5;

    public Inventory() {}
    public Long getInventoryId() { return inventoryId; }
    public void setInventoryId(Long inventoryId) { this.inventoryId = inventoryId; }
    public Product getProduct() { return product; }
    public void setProduct(Product product) { this.product = product; }
    public DistributionCentre getCentre() { return centre; }
    public void setCentre(DistributionCentre centre) { this.centre = centre; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public int getReorderLevel() { return reorderLevel; }
    public void setReorderLevel(int reorderLevel) { this.reorderLevel = reorderLevel; }
    public boolean isLowStock() { return quantity <= reorderLevel; }
}
