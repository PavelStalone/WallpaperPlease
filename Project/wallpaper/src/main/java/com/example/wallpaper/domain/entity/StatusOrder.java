package com.example.wallpaper.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "status_order")
public class StatusOrder extends BaseEntity {

    private String status;

    public StatusOrder(String status) {
        this.status = status;
    }

    protected StatusOrder() {
    }

    @Column(name = "status", unique = true, nullable = false)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
