package com.example.wallpaper.core.service.impl;

import com.example.wallpaper.common.log.Log;
import com.example.wallpaper.common.mapper.Mapper;
import com.example.wallpaper.core.service.contract.OptimalCostService;
import com.example.wallpaper.core.service.contract.UserService;
import com.example.wallpaper.core.system.OptimalCostSystem;
import com.example.wallpaper.data.model.OrderDto;
import com.example.wallpaper.data.model.UserDto;
import com.example.wallpaper.domain.entity.Order;
import com.example.wallpaper.domain.repository.contract.OrderRepository;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class OptimalCostServiceImpl implements OptimalCostService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    UserService userService;

    @Autowired
    OptimalCostSystem optimalCostSystem;

    @Override
    public int findOptimalCostForOrder(OrderDto order) {
        Log.d("FindOptimalCostForOrder called. Order = %s", order.toString());
        TypeMap<Order, OrderDto> mapper = Mapper.createTypeMap(Order.class, OrderDto.class);
        Set<OrderDto> orders = orderRepository.getAllOrdersByWallpaperTypeId(order.getWpType().getId()).stream()
                .map(mapper::map)
                .collect(Collectors.toSet());
        UserDto owner = userService.findUserById(order.getOwnerId());

        return optimalCostSystem.calculateOptimalCost(order, orders, owner);
    }
}
