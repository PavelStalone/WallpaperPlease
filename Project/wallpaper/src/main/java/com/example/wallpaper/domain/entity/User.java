package com.example.wallpaper.domain.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "users")
public class User extends BaseEntity {

    private Date date;
    private String name;
    private String icon;
    private String email;
    private String password; // Store hash code of course :)
    private Developer developer;
    private Set<Wallpaper> ownWallpapers;
    private Set<UserComment> userComments;
    private Set<Wallpaper> accessWallpapers;

    public User(
            Date date,
            String name,
            String icon,
            String email,
            String password,
            Set<String> allEmails
    ) {
        if (allEmails.contains(email)) throw new IllegalArgumentException("Email not unique");

        this.date = date;
        this.name = name;
        this.icon = icon;
        this.email = email;
        this.password = password;
    }

    protected User() {
    }

    @OneToMany(mappedBy = "user", targetEntity = UserComment.class, fetch = FetchType.LAZY)
    public Set<UserComment> getUserComments() {
        return userComments;
    }

    public void setUserComments(Set<UserComment> userComments) {
        this.userComments = userComments;
    }

    @ManyToMany(mappedBy = "userAccess", targetEntity = Wallpaper.class, fetch = FetchType.LAZY)
    public Set<Wallpaper> getAccessWallpapers() {
        return accessWallpapers;
    }

    public void setAccessWallpapers(Set<Wallpaper> accessWallpapers) {
        this.accessWallpapers = accessWallpapers;
    }

    @OneToMany(mappedBy = "id", targetEntity = Wallpaper.class, fetch = FetchType.LAZY)
    public Set<Wallpaper> getOwnWallpapers() {
        return ownWallpapers;
    }

    public void setOwnWallpapers(Set<Wallpaper> ownWallpapers) {
        this.ownWallpapers = ownWallpapers;
    }

    @OneToOne(mappedBy = "user", targetEntity = Developer.class)
    public Developer getDeveloper() {
        return developer;
    }

    public void setDeveloper(Developer developer) {
        this.developer = developer;
    }

    @Column(name = "name", length = 50, unique = true, nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "date", nullable = false)
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Column(name = "email", unique = true, nullable = false)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "password", nullable = false)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "icon", length = 2048)
    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
