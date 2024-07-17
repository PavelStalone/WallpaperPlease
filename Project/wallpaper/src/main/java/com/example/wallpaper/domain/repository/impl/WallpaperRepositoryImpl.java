package com.example.wallpaper.domain.repository.impl;

import com.example.wallpaper.domain.entity.Wallpaper;
import com.example.wallpaper.domain.repository.contract.DefaultWallpaperRepository;
import com.example.wallpaper.domain.repository.contract.WallpaperRepository;
import org.springframework.stereotype.Repository;

@Repository
public class WallpaperRepositoryImpl extends BaseRepository<DefaultWallpaperRepository> implements WallpaperRepository {

    @Override
    public Iterable<Wallpaper> getAll() {
        return repository.findAll();
    }

    @Override
    public Iterable<Wallpaper> getAllByCost(int cost) {
        return repository.getAllByCostLessThanEqual(cost);
    }

    @Override
    public Iterable<Wallpaper> getAllByEfficiency(int efficiency) {
        return repository.getAllByEfficiencyLessThanEqual(efficiency);
    }

    @Override
    public Iterable<Wallpaper> getAllByEfficiencyAndCost(int efficiency, int cost) {
        return repository.getAllByEfficiencyAndCost(efficiency, cost);
    }
}
