package com.example.wallpaper.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "groups")
public class Group extends BaseEntity {

    private Date date;
    private String name;
    private String icon;
    private String description;
    private Set<Developer> members;

    public Group(
            Date date,
            String name,
            String icon,
            String description
    ) {
        this.date = date;
        this.name = name;
        this.icon = icon;
        this.description = description;
    }

    protected Group() {
    }

    @OneToMany
    public Set<Developer> getMembers() {
        return members;
    }

    public void setMembers(Set<Developer> members) {
        this.members = members;
    }

    @Column(name = "name", length = 50, unique = true, nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "description", length = 500)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "date", nullable = false)
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Column(name = "icon", length = 2048)
    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
