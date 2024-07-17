package com.example.wallpaper.domain.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "active_order")
public class ActiveOrder {

    private int cost;
    private Long time;
    private Order order;
    private Date endDate;
    private Date startDate;
    private String description;
    private StatusOrder status;
    private Developer developer;

    public ActiveOrder(
            int cost,
            Long time,
            Order order,
            Date endDate,
            Date startDate,
            String description,
            StatusOrder status,
            Developer developer
    ) {
        this.cost = cost;
        this.time = time;
        this.order = order;
        this.status = status;
        this.endDate = endDate;
        this.startDate = startDate;
        this.developer = developer;
        this.description = description;
    }

    protected ActiveOrder() {
    }

    @EmbeddedId
    @ManyToOne(optional = false)
    @JoinColumn(name = "order_id", referencedColumnName = "id", nullable = false)
    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @EmbeddedId
    @ManyToOne(optional = false)
    @JoinColumn(name = "developer_id", referencedColumnName = "id", nullable = false)
    public Developer getDeveloper() {
        return developer;
    }

    public void setDeveloper(Developer developer) {
        this.developer = developer;
    }

    @Column(name = "time")
    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    @Column(name = "cost", nullable = false)
    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Column(name = "description", length = 500)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @ManyToOne(optional = false)
    @JoinColumn(name = "status", referencedColumnName = "id", nullable = false)
    public StatusOrder getStatus() {
        return status;
    }

    public void setStatus(StatusOrder status) {
        this.status = status;
    }

    @Column(name = "start_date")
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Column(name = "end_date")
    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
