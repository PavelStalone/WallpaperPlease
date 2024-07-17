package com.example.wallpaper.domain.repository.impl;

import com.example.wallpaper.domain.entity.Order;
import com.example.wallpaper.domain.repository.contract.DefaultOrderRepository;
import com.example.wallpaper.domain.repository.contract.OrderRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public class OrderRepositoryImpl extends BaseRepository<DefaultOrderRepository> implements OrderRepository {

    @Override
    public Order getOrderById(long id) {
        return repository.getReferenceById(id);
    }

    @Override
    public List<Order> getAllOrders() {
        return repository.findAll();
    }

    @Override
    public Set<Order> getAllOrdersByWallpaperTypeId(long typeId) {
        return repository.getAllByWallpaperTypeId(typeId);
    }
}
