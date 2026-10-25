package com.stylesstock.stylestock.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Supplier {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long supplierId;
    @NotBlank private String supplierName;
    @Email private String email;
    private String phone;

    public Supplier() {}
    public Supplier(String supplierName, String email, String phone) { this.supplierName = supplierName; this.email = email; this.phone = phone; }
    public Long getSupplierId() { return supplierId; }
    public void setSupplierId(Long supplierId) { this.supplierId = supplierId; }
    public String getSupplierName() { return supplierName; }
    public void setSupplierName(String supplierName) { this.supplierName = supplierName; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    @Override public String toString() { return supplierName; }
}
