package com.example.wallpaper.core.service.contract;

import com.example.wallpaper.data.model.OptimalActiveOrderDto;
import com.example.wallpaper.data.model.OrderDto;

public interface OptimalActiveOrderService {

    Iterable<OptimalActiveOrderDto> findOptimalActiveOrders(OrderDto order, int limit);
}
