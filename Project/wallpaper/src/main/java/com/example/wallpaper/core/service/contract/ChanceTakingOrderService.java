package com.example.wallpaper.core.service.contract;

import com.example.wallpaper.data.model.OrderDto;

public interface ChanceTakingOrderService {

    float findChanceTakingOrder(OrderDto order);
}
