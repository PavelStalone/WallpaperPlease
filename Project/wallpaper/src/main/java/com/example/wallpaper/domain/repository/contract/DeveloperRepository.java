package com.example.wallpaper.domain.repository.contract;

import com.example.wallpaper.domain.entity.Developer;

public interface DeveloperRepository {

    Iterable<Developer> getAllByWantWork(boolean wantWork);
    Developer getDeveloperById(Long id);
    void createDeveloper(Developer developer);
}
