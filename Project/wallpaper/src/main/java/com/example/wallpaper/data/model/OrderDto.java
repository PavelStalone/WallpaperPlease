package com.example.wallpaper.data.model;

import java.util.Date;

public class OrderDto {

    private long id;
    private int cost;
    private long ownerId;
    private Date createDate;
    private long developerId;
    private long wallpaperId;
    private Date completeDate;
    private String description;
    private boolean visibility;
    private StatusOrderDto status;
    private boolean canDeveloperUse;
    private WallpaperTypeDto wpType;

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

    public long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(long ownerId) {
        this.ownerId = ownerId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public long getDeveloperId() {
        return developerId;
    }

    public void setDeveloperId(long developerId) {
        this.developerId = developerId;
    }

    public long getWallpaperId() {
        return wallpaperId;
    }

    public void setWallpaperId(long wallpaperId) {
        this.wallpaperId = wallpaperId;
    }

    public Date getCompleteDate() {
        return completeDate;
    }

    public void setCompleteDate(Date completeDate) {
        this.completeDate = completeDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isVisibility() {
        return visibility;
    }

    public void setVisibility(boolean visibility) {
        this.visibility = visibility;
    }

    public StatusOrderDto getStatus() {
        return status;
    }

    public void setStatus(StatusOrderDto status) {
        this.status = status;
    }

    public boolean isCanDeveloperUse() {
        return canDeveloperUse;
    }

    public void setCanDeveloperUse(boolean canDeveloperUse) {
        this.canDeveloperUse = canDeveloperUse;
    }

    public WallpaperTypeDto getWpType() {
        return wpType;
    }

    public void setWpType(WallpaperTypeDto wpType) {
        this.wpType = wpType;
    }

    @Override
    public String toString() {
        return "OrderDto{" +
                "id=" + id +
                ", cost=" + cost +
                ", ownerId=" + ownerId +
                ", createDate=" + createDate +
                ", developerId=" + developerId +
                ", wallpaperId=" + wallpaperId +
                ", completeDate=" + completeDate +
                ", description='" + description + '\'' +
                ", visibility=" + visibility +
                ", status=" + status +
                ", canDeveloperUse=" + canDeveloperUse +
                ", wpType=" + wpType +
                '}';
    }
}
