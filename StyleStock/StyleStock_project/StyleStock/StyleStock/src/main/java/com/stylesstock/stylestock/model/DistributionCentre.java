package com.stylesstock.stylestock.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
public class DistributionCentre {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long centreId;
    @NotBlank private String centreName;
    private String address;
    private String city;

    public DistributionCentre() {}
    public DistributionCentre(String centreName, String address, String city) { this.centreName = centreName; this.address = address; this.city = city; }
    public Long getCentreId() { return centreId; }
    public void setCentreId(Long centreId) { this.centreId = centreId; }
    public String getCentreName() { return centreName; }
    public void setCentreName(String centreName) { this.centreName = centreName; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }
    @Override public String toString() { return centreName; }
}
