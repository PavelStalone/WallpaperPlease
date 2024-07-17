package com.example.wallpaper.domain.entity;

import jakarta.persistence.*;

@MappedSuperclass
public abstract class BaseEntity {

    private long id;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
