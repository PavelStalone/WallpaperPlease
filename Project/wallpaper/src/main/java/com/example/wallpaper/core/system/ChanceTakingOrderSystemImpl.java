package com.example.wallpaper.core.system;

import com.example.wallpaper.common.Constants;
import com.example.wallpaper.common.log.Log;
import com.example.wallpaper.data.model.DeveloperDto;
import com.example.wallpaper.data.model.OrderDto;
import com.example.wallpaper.data.model.UserDto;

import java.time.temporal.ChronoUnit;
import java.util.Set;

public class ChanceTakingOrderSystemImpl implements ChanceTakingOrderSystem {

    @Override
    public float calculateChance(OrderDto order, UserDto owner, Set<DeveloperDto> developers, int recommendedCost) {
        Log.d(
                "CalculateChance called. Order = %s, owner = %s, developers = %s, recommendedCost = %d",
                order.toString(),
                owner.toString(),
                developers.toString(),
                recommendedCost
        );
        if (developers.isEmpty()) throw new IllegalArgumentException("Developers must not be empty");

        int difficult = order.getWpType().getDifficult();
        float ownerMark = owner.getMark();
        int cost = order.getCost();
        float chance = 1f;
        Long duration = null;

        if (order.getCompleteDate() != null) {
            duration = ChronoUnit.MINUTES.between(
                    order.getCreateDate().toInstant(),
                    order.getCompleteDate().toInstant()
            );
        }
        if (duration != null) {
            long days = (duration / 60 / 24);
            chance *= (days >= difficult) ? 1f : (float) days / difficult;
        }

        chance *= (double) developers.stream().filter(developer -> developer.getWorkExperience() >= difficult).count() / developers.size();
        chance *= (cost >= recommendedCost) ? 1f : (float) cost / recommendedCost;
        chance *= ownerMark / Constants.MAX_MARK;

        return chance;
    }
}
