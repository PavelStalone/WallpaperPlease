package com.example.wallpaper.core.system;

import com.example.wallpaper.common.Constants;
import com.example.wallpaper.common.log.Log;
import com.example.wallpaper.data.model.OrderDto;
import com.example.wallpaper.data.model.UserDto;

import java.time.temporal.ChronoUnit;
import java.util.Set;

public class OptimalCostSystemImpl implements OptimalCostSystem {

    @Override
    public int calculateOptimalCost(OrderDto orderDto, Set<OrderDto> similarOrders, UserDto owner) {
        Log.d(
                "CalculateOptimalCost called. orderDto = %s, similarOrders = %s, owner = %s",
                orderDto.toString(),
                similarOrders.toString(),
                owner.toString()
        );
        int averageCost = (int) similarOrders.stream().mapToInt(OrderDto::getCost).average().orElse(0.0);
        float markOwner = owner.getMark();
        Long duration = null;
        int cost = averageCost;

        if (orderDto.getCompleteDate() != null) {
            duration = ChronoUnit.MINUTES.between(
                    orderDto.getCreateDate().toInstant(),
                    orderDto.getCompleteDate().toInstant()
            );
        }

        if (duration != null) cost -= Math.min(duration * 0.2, averageCost / 3f);
        cost += ((Constants.MAX_MARK - markOwner) * averageCost / 10f);

        return cost;
    }
}
