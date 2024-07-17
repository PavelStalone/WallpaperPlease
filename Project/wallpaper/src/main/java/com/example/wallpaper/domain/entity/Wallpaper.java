package com.example.wallpaper.domain.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "wallpapers")
public class Wallpaper extends BaseEntity {

    private int cost;
    private long size;
    private Date date;
    private String url;
    private User owner;
    private String name;
    private String description;
    private boolean visibility;
    private WallpaperType type;
    private int downloadCounter;
    private WallpaperTheme theme;
    private Set<User> userAccess;
    private Set<WallpaperComment> comments;

    public Wallpaper(
            int cost,
            long size,
            Date date,
            String url,
            User owner,
            String name,
            String description,
            boolean visibility,
            WallpaperType type,
            int downloadCounter,
            WallpaperTheme theme
    ) {
        this.url = url;
        this.cost = cost;
        this.size = size;
        this.date = date;
        this.name = name;
        this.type = type;
        this.theme = theme;
        this.owner = owner;
        this.visibility = visibility;
        this.description = description;
        this.downloadCounter = downloadCounter;
    }

    protected Wallpaper() {
    }

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "wallpaper_access",
            joinColumns = @JoinColumn(name = "wallpaper_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id")
    )
    public Set<User> getUserAccess() {
        return userAccess;
    }

    public void setUserAccess(Set<User> userAccess) {
        this.userAccess = userAccess;
    }

    @ManyToOne(optional = false)
    @JoinColumn(name = "owner_id", referencedColumnName = "id", nullable = false)
    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    @ManyToOne(optional = false)
    @JoinColumn(name = "type_id", referencedColumnName = "id", nullable = false)
    public WallpaperType getType() {
        return type;
    }

    public void setType(WallpaperType type) {
        this.type = type;
    }

    @ManyToOne
    @JoinColumn(name = "theme_id", referencedColumnName = "id")
    public WallpaperTheme getTheme() {
        return theme;
    }

    public void setTheme(WallpaperTheme theme) {
        this.theme = theme;
    }

    @OneToMany(mappedBy = "wallpaper", targetEntity = WallpaperComment.class, fetch = FetchType.LAZY)
    public Set<WallpaperComment> getComments() {
        return comments;
    }

    public void setComments(Set<WallpaperComment> comments) {
        this.comments = comments;
    }

    @Column(name = "name", length = 50, nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "size", nullable = false)
    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    @Column(name = "date", nullable = false)
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Column(name = "download_counter", nullable = false)
    public int getDownloadCounter() {
        return downloadCounter;
    }

    public void setDownloadCounter(int downloadCounter) {
        this.downloadCounter = downloadCounter;
    }

    @Column(name = "description", length = 500)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "visibility", nullable = false)
    public boolean isVisibility() {
        return visibility;
    }

    public void setVisibility(boolean visibility) {
        this.visibility = visibility;
    }

    @Column(name = "cost", nullable = false)
    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Column(name = "url", length = 2048, nullable = false)
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
