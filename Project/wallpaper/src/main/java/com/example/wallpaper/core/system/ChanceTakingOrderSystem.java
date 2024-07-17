package com.example.wallpaper.core.system;

import com.example.wallpaper.data.model.DeveloperDto;
import com.example.wallpaper.data.model.OrderDto;
import com.example.wallpaper.data.model.UserDto;

import java.util.Set;

public interface ChanceTakingOrderSystem {

    float calculateChance(OrderDto order, UserDto owner, Set<DeveloperDto> developers, int recommendedCost);
}
