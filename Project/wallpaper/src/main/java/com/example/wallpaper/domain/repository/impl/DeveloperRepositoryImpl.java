package com.example.wallpaper.domain.repository.impl;

import com.example.wallpaper.domain.entity.Developer;
import com.example.wallpaper.domain.repository.contract.DefaultDeveloperRepository;
import com.example.wallpaper.domain.repository.contract.DeveloperRepository;
import org.springframework.stereotype.Repository;

@Repository
public class DeveloperRepositoryImpl extends BaseRepository<DefaultDeveloperRepository> implements DeveloperRepository {

    @Override
    public Iterable<Developer> getAllByWantWork(boolean wantWork) {
        return repository.getAllByWantWork(wantWork);
    }

    @Override
    public Developer getDeveloperById(Long id) {
        return repository.getReferenceById(id);
    }

    @Override
    public void createDeveloper(Developer developer) {
        repository.save(developer);
    }
}
