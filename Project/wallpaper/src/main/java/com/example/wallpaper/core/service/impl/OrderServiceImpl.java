package com.example.wallpaper.core.service.impl;

import com.example.wallpaper.common.log.Log;
import com.example.wallpaper.common.mapper.Mapper;
import com.example.wallpaper.core.service.contract.OrderService;
import com.example.wallpaper.data.model.DeveloperDto;
import com.example.wallpaper.data.model.OptimalActiveOrderDto;
import com.example.wallpaper.data.model.OrderDto;
import com.example.wallpaper.domain.entity.ActiveOrder;
import com.example.wallpaper.domain.entity.Developer;
import com.example.wallpaper.domain.entity.Order;
import com.example.wallpaper.domain.repository.contract.OrderRepository;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Override
    public Set<OrderDto> getAll() {
        TypeMap<Order, OrderDto> mapper = Mapper.createTypeMap(Order.class, OrderDto.class);
        return orderRepository.getAllOrders().stream()
                .map(mapper::map)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<DeveloperDto> getAllDevelopersWhoWantWorks(OrderDto order) {
        Log.d("GetAllDevelopersWhoWantWorks called. Order = %s", order.toString());
        Order orderEntity = orderRepository.getOrderById(order.getId());
        Set<Developer> allDevelopers = new HashSet<>();
        allDevelopers.addAll(orderEntity.getDevelopers());
        allDevelopers.addAll(orderEntity.getGroups()
                .stream()
                .flatMap(group -> group.getMembers().stream())
                .collect(Collectors.toSet())
        );

        TypeMap<Developer, DeveloperDto> mapper = Mapper.createTypeMap(Developer.class, DeveloperDto.class);
        return allDevelopers.stream()
                .filter(Developer::isWantWork)
                .map(mapper::map)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<OptimalActiveOrderDto> getAllOptimalActiveOrder(OrderDto order) {
        Log.d("GetAllOptimalActiveOrder called. Order = %s", order.toString());
        TypeMap<ActiveOrder, OptimalActiveOrderDto> mapper = Mapper.createTypeMap(ActiveOrder.class, OptimalActiveOrderDto.class);
        Order orderEntity = orderRepository.getOrderById(order.getId());
        return orderEntity.getActiveOrders().stream()
                .map(mapper::map)
                .collect(Collectors.toSet());
    }
}
