package com.example.wallpaper.data.model;

import java.util.Objects;

public class WallpaperThemeDto {

    private long id;
    private String theme;

    protected WallpaperThemeDto() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WallpaperThemeDto that = (WallpaperThemeDto) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "WallpaperThemeDto{" +
                "id=" + id +
                ", theme='" + theme + '\'' +
                '}';
    }
}
