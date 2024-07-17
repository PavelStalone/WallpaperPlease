package com.example.wallpaper.domain.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.Repository;

abstract class BaseRepository<T extends Repository<?, ?>> {

    @Autowired
    protected T repository;
}
