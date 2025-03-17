package com.example.model;

import javax.persistence.Entity;
import javax.persistence.*;

@Entity
@Table(name = "SERVICETYPE")
public class ServiceType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SERVICETYPEID")
    private Long serviceTypeId;

    @Column(name = "SERVICENAME")
    private String serviceName;

    @Column(name = "PRICE")
    private Double price;

    @Column(name = "DURATION")
    private Integer duration;

    // Getters and setters
    public Long getServiceTypeId() {
        return serviceTypeId;
    }

    public void setServiceTypeId(Long serviceTypeId) {
        this.serviceTypeId = serviceTypeId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }
}
