package com.example.wallpaper.data.model;

import java.util.Objects;

public class WallpaperTypeDto {

    private long id;
    private String type;
    private int difficult;
    private int efficiency;

    protected WallpaperTypeDto() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getDifficult() {
        return difficult;
    }

    public void setDifficult(int difficult) {
        this.difficult = difficult;
    }

    public int getEfficiency() {
        return efficiency;
    }

    public void setEfficiency(int efficiency) {
        this.efficiency = efficiency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WallpaperTypeDto that = (WallpaperTypeDto) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "WallpaperTypeDto{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", difficult=" + difficult +
                ", efficiency=" + efficiency +
                '}';
    }
}
