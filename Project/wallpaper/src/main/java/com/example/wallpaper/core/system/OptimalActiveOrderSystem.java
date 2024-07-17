package com.example.wallpaper.core.system;

import com.example.wallpaper.data.model.OptimalActiveOrderDto;
import com.example.wallpaper.data.model.OrderDto;

import java.util.Set;

public interface OptimalActiveOrderSystem {

    Set<OptimalActiveOrderDto> calculateOptimal(Set<OptimalActiveOrderDto> developers, OrderDto order);
}
