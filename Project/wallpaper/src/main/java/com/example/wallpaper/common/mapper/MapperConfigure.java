package com.example.wallpaper.common.mapper;

import org.modelmapper.TypeMap;

public interface MapperConfigure<S, D> {

    public TypeMap<S, D> configure(TypeMap<S, D> mapper);
}
