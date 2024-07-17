package com.example.wallpaper.data.model;

import com.example.wallpaper.domain.entity.User;

import java.util.Date;

public class WallpaperDto {

    private long id;
    private int cost;
    private long size;
    private Date date;
    private String url;
    private User owner;
    private String name;
    private String description;
    private boolean visibility;
    private int downloadCounter;
    private WallpaperTypeDto type;
    private WallpaperThemeDto theme;

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

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getDownloadCounter() {
        return downloadCounter;
    }

    public void setDownloadCounter(int downloadCounter) {
        this.downloadCounter = downloadCounter;
    }

    public WallpaperTypeDto getType() {
        return type;
    }

    public void setType(WallpaperTypeDto type) {
        this.type = type;
    }

    public WallpaperThemeDto getTheme() {
        return theme;
    }

    public void setTheme(WallpaperThemeDto theme) {
        this.theme = theme;
    }
}
