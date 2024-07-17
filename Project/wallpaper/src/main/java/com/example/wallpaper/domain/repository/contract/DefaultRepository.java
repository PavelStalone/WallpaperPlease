package com.example.wallpaper.domain.repository.contract;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface DefaultRepository<T> extends JpaRepository<T, Long> {
}
