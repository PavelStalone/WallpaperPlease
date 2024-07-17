package com.example.wallpaper.domain.repository.contract;

import com.example.wallpaper.domain.entity.Wallpaper;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface DefaultWallpaperRepository extends DefaultRepository<Wallpaper> {

    Iterable<Wallpaper> getAllByCostLessThanEqual(int cost);

    @Query(value = "SELECT w FROM Wallpaper w INNER JOIN w.type wt WHERE wt.efficiency <= :efficiency AND w.cost <= :cost")
    Iterable<Wallpaper> getAllByEfficiencyAndCost(
            @Param(value = "efficiency") int efficiency,
            @Param(value = "cost") int cost
    );

    @Query(value = "SELECT w FROM Wallpaper w INNER JOIN w.type wt WHERE wt.efficiency <= :efficiency")
    Iterable<Wallpaper> getAllByEfficiencyLessThanEqual(@Param(value = "efficiency") int efficiency);
}
