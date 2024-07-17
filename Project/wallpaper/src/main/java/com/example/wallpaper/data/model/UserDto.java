package com.example.wallpaper.data.model;

import java.util.Date;

public class UserDto {

    private Long id;
    private Date date;
    private float mark;
    private String name;
    private String icon;
    private String email;
    private boolean isDeveloper;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public float getMark() {
        return mark;
    }

    public void setMark(float mark) {
        this.mark = mark;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isDeveloper() {
        return isDeveloper;
    }

    public void setDeveloper(boolean developer) {
        isDeveloper = developer;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "date=" + date +
                ", name='" + name + '\'' +
                ", icon='" + icon + '\'' +
                ", email='" + email + '\'' +
                ", isDeveloper=" + isDeveloper +
                '}';
    }
}
