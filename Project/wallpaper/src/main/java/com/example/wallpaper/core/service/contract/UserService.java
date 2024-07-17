package com.example.wallpaper.core.service.contract;

import com.example.wallpaper.data.model.UserDto;

public interface UserService {

    UserDto getUser(String email, String password);

    void registerUser(UserDto user);

    UserDto findUserById(long userId);

    Iterable<UserDto> getAllUsers();
}
