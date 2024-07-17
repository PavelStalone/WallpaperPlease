package com.example.wallpaper.domain.repository.contract;

import com.example.wallpaper.domain.entity.Order;

import java.util.List;
import java.util.Set;

public interface OrderRepository {

    Order getOrderById(long id);

    List<Order> getAllOrders();

    Set<Order> getAllOrdersByWallpaperTypeId(long typeId);
}
