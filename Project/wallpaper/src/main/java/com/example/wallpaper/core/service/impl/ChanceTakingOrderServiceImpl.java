package com.example.wallpaper.core.service.impl;

import com.example.wallpaper.common.log.Log;
import com.example.wallpaper.core.service.contract.ChanceTakingOrderService;
import com.example.wallpaper.core.service.contract.OptimalCostService;
import com.example.wallpaper.core.service.contract.OrderService;
import com.example.wallpaper.core.service.contract.UserService;
import com.example.wallpaper.core.system.ChanceTakingOrderSystem;
import com.example.wallpaper.data.model.DeveloperDto;
import com.example.wallpaper.data.model.OrderDto;
import com.example.wallpaper.data.model.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ChanceTakingOrderServiceImpl implements ChanceTakingOrderService {

    @Autowired
    UserService userService;

    @Autowired
    OrderService orderService;

    @Autowired
    OptimalCostService optimalCostService;

    @Autowired
    ChanceTakingOrderSystem chanceTakingOrderSystem;

    @Override
    public float findChanceTakingOrder(OrderDto order) {
        Log.d("FindChanceTakingOrder called. Order = %s", order.toString());
        UserDto owner = userService.findUserById(order.getOwnerId());
        Set<DeveloperDto> developers = orderService.getAllDevelopersWhoWantWorks(order);
        int recommendedCost = optimalCostService.findOptimalCostForOrder(order);

        return chanceTakingOrderSystem.calculateChance(order, owner, developers, recommendedCost);
    }
}
