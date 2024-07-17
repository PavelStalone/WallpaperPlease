package com.example.wallpaper.common.mapper;

import com.example.wallpaper.common.Constants;
import com.example.wallpaper.common.log.Log;
import com.example.wallpaper.data.model.DeveloperDto;
import com.example.wallpaper.data.model.OptimalActiveOrderDto;
import com.example.wallpaper.data.model.OrderDto;
import com.example.wallpaper.data.model.UserDto;
import com.example.wallpaper.domain.entity.*;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;

import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Map;

import static java.util.Map.entry;

public class Mapper {

    private static final Map<String, MapperConfigure<?, ?>> map = Map.ofEntries(
            entry(User.class.getName() + "-" + UserDto.class.getName(), (MapperConfigure<User, UserDto>) mapper -> {
                Converter<Developer, Float> markConverter = c -> {
                    if (c.getSource() != null) {
                        return (float) c.getSource().getWorkResults().stream()
                                .mapToInt(WorkResult::getMark)
                                .average()
                                .orElse(Constants.MAX_MARK / 2f);
                    } else {
                        return Constants.MAX_MARK / 2f;
                    }
                };

                Converter<Developer, Boolean> isDeveloperConverter = c -> c.getSource() != null;

                return mapper.addMappings(map -> map.using(markConverter).map(User::getDeveloper, UserDto::setMark))
                        .addMappings(map -> map.using(isDeveloperConverter).map(User::getDeveloper, UserDto::setDeveloper));
            }),
            entry(Developer.class.getName() + "-" + DeveloperDto.class.getName(), (MapperConfigure<Developer, DeveloperDto>) mapper -> {
                Converter<Date, Float> workExperienceConverter = c -> ChronoUnit.DAYS.between(
                        c.getSource().toInstant(),
                        ZonedDateTime.now().toInstant()
                ) / 365f;

                return mapper.addMappings(map -> map.using(workExperienceConverter)
                        .map(Developer::getDate, DeveloperDto::setWorkExperience)
                );
            }),
            entry(Order.class.getName() + "-" + OrderDto.class.getName(), (MapperConfigure<Order, OrderDto>) mapper -> {
                return mapper.addMapping(Order::getWallpaperType, OrderDto::setWpType);
            }),
            entry(ActiveOrder.class.getName() + "-" + OptimalActiveOrderDto.class.getName(), (MapperConfigure<ActiveOrder, OptimalActiveOrderDto>) mapper -> {

                Converter<Developer, Float> markConverter = c -> {
                    if (c.getSource() != null && !c.getSource().getWorkResults().isEmpty()) {
                        return (float) c.getSource().getWorkResults().stream()
                                .mapToInt(WorkResult::getMark)
                                .average()
                                .orElse(Constants.MAX_MARK / 2f);
                    } else {
                        return Constants.MAX_MARK / 2f;
                    }
                };
                Converter<Developer, Float> workExperienceConverter = c -> ChronoUnit.DAYS.between(
                        c.getSource().getDate().toInstant(),
                        ZonedDateTime.now().toInstant()
                ) / 365f;

                return mapper.addMappings(map -> map.skip(OptimalActiveOrderDto::setPercent))
                        .addMapping(ActiveOrder::getTime, OptimalActiveOrderDto::setDuration)
                        .addMapping(s -> s.getDeveloper().getId(), OptimalActiveOrderDto::setId)
                        .addMapping(s -> s.getOrder().getId(), OptimalActiveOrderDto::setOrderId)
                        .addMapping(s -> s.getDeveloper().getDate(), OptimalActiveOrderDto::setDeveloperDate)
                        .addMappings(map -> map.using(markConverter).map(ActiveOrder::getDeveloper, OptimalActiveOrderDto::setMark))
                        .addMappings(map -> map.using(workExperienceConverter).map(ActiveOrder::getDeveloper, OptimalActiveOrderDto::setWorkExperience));
            })
    );

    public static <S, D> TypeMap<S, D> createTypeMap(Class<S> sourceClass, Class<D> destinationClass) {
        Log.d("CreateTypeMap called. source: %s, destination: %s", sourceClass.getName(), destinationClass.getName());
        TypeMap<S, D> typeMap = new ModelMapper().createTypeMap(sourceClass, destinationClass);
        String key = sourceClass.getName() + "-" + destinationClass.getName();

        if (map.containsKey(key)) {
            Log.d("Property map found. Use special settings");
            typeMap = ((MapperConfigure<S, D>) map.get(key)).configure(typeMap);
        } else {
            Log.d("Property map not found. Use defaults mapper");
        }
        return typeMap;
    }
}
