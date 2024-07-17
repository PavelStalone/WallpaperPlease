package com.example.wallpaper.domain.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "orders")
public class Order extends BaseEntity {

    private int cost;
    private User owner;
    private Date createDate;
    private Date completeDate;
    private Set<Group> groups;
    private String description;
    private StatusOrder status;
    private boolean visibility;
    private Developer developer;
    private Wallpaper wallpaper;
    private boolean canDeveloperUse;
    private Set<Developer> developers;
    private WallpaperType wallpaperType;
    private Set<ActiveOrder> activeOrders;

    public Order(
            int cost,
            User owner,
            Date createDate,
            Date completeDate,
            String description,
            StatusOrder status,
            boolean visibility,
            Developer developer,
            Wallpaper wallpaper,
            boolean canDeveloperUse,
            WallpaperType wallpaperType
    ) {
        this.cost = cost;
        this.owner = owner;
        this.status = status;
        this.developer = developer;
        this.wallpaper = wallpaper;
        this.createDate = createDate;
        this.visibility = visibility;
        this.description = description;
        this.completeDate = completeDate;
        this.wallpaperType = wallpaperType;
        this.canDeveloperUse = canDeveloperUse;
    }

    protected Order() {
    }

    @OneToMany(mappedBy = "order", targetEntity = ActiveOrder.class)
    public Set<ActiveOrder> getActiveOrders() {
        return activeOrders;
    }

    public void setActiveOrders(Set<ActiveOrder> activeOrders) {
        this.activeOrders = activeOrders;
    }

    @ManyToMany
    @JoinTable(
            name = "developer_order",
            joinColumns = @JoinColumn(name = "order_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "developer_id", referencedColumnName = "id")
    )
    public Set<Developer> getDevelopers() {
        return developers;
    }

    public void setDevelopers(Set<Developer> developers) {
        this.developers = developers;
    }

    @ManyToMany
    @JoinTable(
            name = "group_order",
            joinColumns = @JoinColumn(name = "order_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "group_id", referencedColumnName = "id")
    )
    public Set<Group> getGroups() {
        return groups;
    }

    public void setGroups(Set<Group> groups) {
        this.groups = groups;
    }

    @ManyToOne(optional = false)
    @JoinColumn(name = "ownerId", referencedColumnName = "id", nullable = false)
    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    @ManyToOne
    @JoinColumn(name = "developer_id", referencedColumnName = "id")
    public Developer getDeveloper() {
        return developer;
    }

    public void setDeveloper(Developer developer) {
        this.developer = developer;
    }

    @OneToOne
    @JoinColumn(name = "wallpaper_id", referencedColumnName = "id")
    public Wallpaper getWallpaper() {
        return wallpaper;
    }

    public void setWallpaper(Wallpaper wallpaper) {
        this.wallpaper = wallpaper;
    }

    @ManyToOne(optional = false)
    @JoinColumn(name = "wallpaper_type_id", referencedColumnName = "id", nullable = false)
    public WallpaperType getWallpaperType() {
        return wallpaperType;
    }

    public void setWallpaperType(WallpaperType wallpaperType) {
        this.wallpaperType = wallpaperType;
    }

    @Column(name = "can_developer_use", nullable = false)
    public boolean isCanDeveloperUse() {
        return canDeveloperUse;
    }

    public void setCanDeveloperUse(boolean canDeveloperUse) {
        this.canDeveloperUse = canDeveloperUse;
    }

    @Column(name = "description", length = 500)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "create_date", nullable = false)
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Column(name = "cost", nullable = false)
    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Column(name = "complete_date")
    public Date getCompleteDate() {
        return completeDate;
    }

    public void setCompleteDate(Date completeDate) {
        this.completeDate = completeDate;
    }

    @Column(name = "visibility", nullable = false)
    public boolean isVisibility() {
        return visibility;
    }

    public void setVisibility(boolean visibility) {
        this.visibility = visibility;
    }

    @ManyToOne(optional = false)
    @JoinColumn(name = "status_id", referencedColumnName = "id", nullable = false)
    public StatusOrder getStatus() {
        return status;
    }

    public void setStatus(StatusOrder status) {
        this.status = status;
    }
}
