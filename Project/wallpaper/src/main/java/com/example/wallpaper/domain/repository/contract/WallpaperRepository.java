package com.example.wallpaper.domain.repository.contract;

import com.example.wallpaper.domain.entity.Wallpaper;

public interface WallpaperRepository {

    Iterable<Wallpaper> getAll();

    Iterable<Wallpaper> getAllByCost(int cost);

    Iterable<Wallpaper> getAllByEfficiency(int efficiency);

    Iterable<Wallpaper> getAllByEfficiencyAndCost(int efficiency, int cost);
}
