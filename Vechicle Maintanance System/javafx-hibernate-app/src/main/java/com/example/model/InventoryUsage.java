package com.example.model;

import javax.persistence.Entity;
import javax.persistence.*;

@Entity
@Table(name = "INVENTORYUSAGE")
public class InventoryUsage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USAGEID")
    private Long usageId;

    @Column(name = "APPOINTMENTID")
    private Long appointmentId;

    @Column(name = "ITEMNAME")
    private String itemName;

    @Column(name = "QUANTITYUSED")
    private Integer quantityUsed;

    @Column(name = "UNITPRICE")
    private Double unitPrice;

    // Getters and setters
    public Long getUsageId() {
        return usageId;
    }

    public void setUsageId(Long usageId) {
        this.usageId = usageId;
    }

    public Long getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(Long appointmentId) {
        this.appointmentId = appointmentId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Integer getQuantityUsed() {
        return quantityUsed;
    }

    public void setQuantityUsed(Integer quantityUsed) {
        this.quantityUsed = quantityUsed;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }
}