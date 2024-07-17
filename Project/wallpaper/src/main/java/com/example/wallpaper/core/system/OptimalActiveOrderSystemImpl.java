package com.example.wallpaper.core.system;

import com.example.wallpaper.common.Constants;
import com.example.wallpaper.common.log.Log;
import com.example.wallpaper.data.model.OptimalActiveOrderDto;
import com.example.wallpaper.data.model.OrderDto;

import java.util.Comparator;
import java.util.Set;
import java.util.stream.Collectors;

public class OptimalActiveOrderSystemImpl implements OptimalActiveOrderSystem {

    @Override
    public Set<OptimalActiveOrderDto> calculateOptimal(Set<OptimalActiveOrderDto> activeOrders, OrderDto order) {
        Log.d(
                "CalculateOptimal called. activeOrders = %s, order = %s",
                activeOrders.toString(),
                order.toString()
        );

        if (activeOrders.isEmpty())
            throw new IllegalArgumentException("active orders must not be empty");

        int minCost = activeOrders.stream().min(Comparator.comparing(OptimalActiveOrderDto::getCost)).orElseThrow().getCost();
        Long minDuration = activeOrders.stream().min(Comparator.comparing(OptimalActiveOrderDto::getDuration)).orElseThrow().getDuration();
        float maxWorkExperience = activeOrders.stream().max(Comparator.comparing(OptimalActiveOrderDto::getWorkExperience)).orElseThrow().getWorkExperience();

        return activeOrders.stream().peek(activeOrder -> {
            float percent = 1f;
            if (activeOrder.getDuration() != null) percent *= 1f / (activeOrder.getDuration() / (double) minDuration);
            percent *= 1f / (activeOrder.getCost() / (float) minCost);
            percent *= activeOrder.getMark() / Constants.MAX_MARK;
            percent *= activeOrder.getWorkExperience() / maxWorkExperience;
            activeOrder.setPercent(percent);
        }).collect(Collectors.toSet());
    }
}
