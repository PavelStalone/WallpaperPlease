package com.example.wallpaper.data.model;

import com.example.wallpaper.domain.entity.StatusOrder;

import java.util.Date;

public class OptimalActiveOrderDto {

    private long id;
    private int cost;
    private float mark;
    private long orderId;
    private Date endDate;
    private Long duration;
    private float percent;
    private Date startDate;
    private long developerId;
    private String description;
    private StatusOrderDto status;
    private Date developerDate;
    private float workExperience;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public float getMark() {
        return mark;
    }

    public void setMark(float mark) {
        this.mark = mark;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public float getPercent() {
        return percent;
    }

    public void setPercent(float percent) {
        this.percent = percent;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public long getDeveloperId() {
        return developerId;
    }

    public void setDeveloperId(long developerId) {
        this.developerId = developerId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public StatusOrderDto getStatus() {
        return status;
    }

    public void setStatus(StatusOrderDto status) {
        this.status = status;
    }

    public Date getDeveloperDate() {
        return developerDate;
    }

    public void setDeveloperDate(Date developerDate) {
        this.developerDate = developerDate;
    }

    public float getWorkExperience() {
        return workExperience;
    }

    public void setWorkExperience(float workExperience) {
        this.workExperience = workExperience;
    }
}
