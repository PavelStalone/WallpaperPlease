package com.example.wallpaper.network.controller;

import com.example.wallpaper.core.service.contract.ChanceTakingOrderService;
import com.example.wallpaper.core.service.contract.OptimalActiveOrderService;
import com.example.wallpaper.core.service.contract.OptimalCostService;
import com.example.wallpaper.core.service.contract.OrderService;
import com.example.wallpaper.data.model.OptimalActiveOrderDto;
import com.example.wallpaper.data.model.OrderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController {

    @Autowired
    OptimalActiveOrderService optimalActiveOrderService;

    @Autowired
    OrderService orderService;

    @Autowired
    OptimalCostService optimalCostService;

    @Autowired
    ChanceTakingOrderService chanceTakingOrderService;

    @GetMapping("/orders")
    Iterable<OrderDto> getAllOrders() {
        return orderService.getAll();
    }

    @PostMapping("/order/chanceTaking")
    float findChanceTakingOrder(@RequestBody OrderDto order) {
        return chanceTakingOrderService.findChanceTakingOrder(order);
    }

    @PostMapping("/order/recommendedPrice")
    int findRecommendedPrice(@RequestBody OrderDto order) {
        return optimalCostService.findOptimalCostForOrder(order);
    }

    @PostMapping("/order/optimalContracts")
    Iterable<OptimalActiveOrderDto> findOptimalActiveOrders(@RequestBody OrderDto order, @RequestParam int limit) {
        return optimalActiveOrderService.findOptimalActiveOrders(order, limit);
    }
}
