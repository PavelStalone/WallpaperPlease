package com.example.wallpaper.domain.repository.contract;

import com.example.wallpaper.domain.entity.Developer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DefaultDeveloperRepository extends DefaultRepository<Developer> {

    @Query(value = "SELECT d FROM Developer d WHERE d.wantWork = :wantWork")
    Iterable<Developer> getAllByWantWork(@Param(value = "wantWork") boolean WantWork);
}
