package com.example.wallpaper.core.service.contract;

import com.example.wallpaper.data.model.DeveloperDto;
import com.example.wallpaper.data.model.OptimalActiveOrderDto;
import com.example.wallpaper.data.model.OrderDto;

import java.util.Set;

public interface OrderService {

    Set<OrderDto> getAll();

    Set<DeveloperDto> getAllDevelopersWhoWantWorks(OrderDto order);

    Set<OptimalActiveOrderDto> getAllOptimalActiveOrder(OrderDto order);
}
