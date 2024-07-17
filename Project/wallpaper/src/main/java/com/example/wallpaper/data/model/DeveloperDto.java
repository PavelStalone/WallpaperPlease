package com.example.wallpaper.data.model;

import java.util.Date;

public class DeveloperDto {

    private long id;
    private Date date;
    private boolean wantWork;
    private float workExperience;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isWantWork() {
        return wantWork;
    }

    public void setWantWork(boolean wantWork) {
        this.wantWork = wantWork;
    }

    public float getWorkExperience() {
        return workExperience;
    }

    public void setWorkExperience(float workExperience) {
        this.workExperience = workExperience;
    }
}
