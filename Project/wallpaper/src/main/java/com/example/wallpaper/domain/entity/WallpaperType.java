package com.example.wallpaper.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "wallpaper_type")
public class WallpaperType extends BaseEntity {

    private String type;
    private int difficult;
    private int efficiency;

    public WallpaperType(
            String type,
            int difficult,
            int efficiency
    ) {
        this.type = type;
        this.difficult = difficult;
        this.efficiency = efficiency;
    }

    protected WallpaperType() {
    }

    @Column(name = "type", length = 50, unique = true, nullable = false)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Column(name = "difficult", nullable = false)
    public int getDifficult() {
        return difficult;
    }

    public void setDifficult(int difficult) {
        this.difficult = difficult;
    }

    @Column(name = "efficiency", nullable = false)
    public int getEfficiency() {
        return efficiency;
    }

    public void setEfficiency(int efficiency) {
        this.efficiency = efficiency;
    }
}
