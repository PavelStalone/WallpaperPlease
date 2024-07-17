package com.example.wallpaper.core.service.impl;

import com.example.wallpaper.common.log.Log;
import com.example.wallpaper.core.service.contract.OptimalActiveOrderService;
import com.example.wallpaper.core.service.contract.OrderService;
import com.example.wallpaper.core.system.OptimalActiveOrderSystem;
import com.example.wallpaper.data.model.OptimalActiveOrderDto;
import com.example.wallpaper.data.model.OrderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class OptimalActiveOrderServiceImpl implements OptimalActiveOrderService {

    @Autowired
    OrderService orderService;

    @Autowired
    OptimalActiveOrderSystem optimalActiveOrderSystem;

    @Override
    public Iterable<OptimalActiveOrderDto> findOptimalActiveOrders(OrderDto order, int limit) {
        Log.d("findOptimalDevelopers called. Order = %s, limit = %d", order.toString(), limit);
        Set<OptimalActiveOrderDto> activeOrders = orderService.getAllOptimalActiveOrder(order);

        return optimalActiveOrderSystem.calculateOptimal(activeOrders, order).stream()
                .sorted(Comparator.comparing(OptimalActiveOrderDto::getPercent).reversed())
                .limit(limit)
                .collect(Collectors.toSet());
    }
}
