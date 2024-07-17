package com.example.wallpaper.domain.repository.contract;

import com.example.wallpaper.domain.entity.Order;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface DefaultOrderRepository extends DefaultRepository<Order> {

    @Query(value = "SELECT o FROM Order o INNER JOIN o.wallpaperType wt WHERE wt.id = :typeId")
    Set<Order> getAllByWallpaperTypeId(@Param(value = "typeId") long typeId);
}
