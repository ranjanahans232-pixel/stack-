package com.stylesstock.stylestock.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import java.time.LocalDate;

@Entity
public class StockTransfer {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transferId;
    @ManyToOne(optional = false) private Product product;
    @ManyToOne(optional = false) private DistributionCentre sourceCentre;
    @ManyToOne(optional = false) private DistributionCentre destinationCentre;
    @Min(1) private int quantity;
    private LocalDate transferDate = LocalDate.now();
    @Enumerated(EnumType.STRING) private TransferStatus status = TransferStatus.PENDING;

    public enum TransferStatus { PENDING, COMPLETED, CANCELLED }
    public StockTransfer() {}
    public Long getTransferId() { return transferId; }
    public void setTransferId(Long transferId) { this.transferId = transferId; }
    public Product getProduct() { return product; }
    public void setProduct(Product product) { this.product = product; }
    public DistributionCentre getSourceCentre() { return sourceCentre; }
    public void setSourceCentre(DistributionCentre sourceCentre) { this.sourceCentre = sourceCentre; }
    public DistributionCentre getDestinationCentre() { return destinationCentre; }
    public void setDestinationCentre(DistributionCentre destinationCentre) { this.destinationCentre = destinationCentre; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public LocalDate getTransferDate() { return transferDate; }
    public void setTransferDate(LocalDate transferDate) { this.transferDate = transferDate; }
    public TransferStatus getStatus() { return status; }
    public void setStatus(TransferStatus status) { this.status = status; }
}
