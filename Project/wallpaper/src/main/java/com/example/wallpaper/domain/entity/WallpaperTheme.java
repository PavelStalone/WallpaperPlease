package com.example.wallpaper.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "wallpaper_theme")
public class WallpaperTheme extends BaseEntity {

    private String theme;

    public WallpaperTheme(String theme) {
        this.theme = theme;
    }

    protected WallpaperTheme() {
    }

    @Column(name = "theme", length = 50, unique = true, nullable = false)
    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }
}
