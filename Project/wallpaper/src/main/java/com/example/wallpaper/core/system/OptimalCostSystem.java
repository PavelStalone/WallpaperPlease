package com.example.wallpaper.core.system;

import com.example.wallpaper.data.model.OrderDto;
import com.example.wallpaper.data.model.UserDto;

import java.util.Set;

public interface OptimalCostSystem {

    int calculateOptimalCost(OrderDto orderDto, Set<OrderDto> similarOrders, UserDto owner);
}
