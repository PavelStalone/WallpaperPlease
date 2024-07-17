package com.example.wallpaper.core.service.impl;

import com.example.wallpaper.common.log.Log;
import com.example.wallpaper.common.mapper.Mapper;
import com.example.wallpaper.core.service.contract.UserService;
import com.example.wallpaper.data.model.UserDto;
import com.example.wallpaper.domain.entity.User;
import com.example.wallpaper.domain.repository.contract.UserRepository;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDto getUser(String email, String password) {
        Log.d("GetUser called. Email = %s, password = %s", email, password);
        User user = userRepository.getUserByEmail(email);

        if (user == null) throw new IllegalArgumentException("User not found");
        if (!user.getPassword().equals(password)) throw new IllegalArgumentException("Wrong password");

        return Mapper.createTypeMap(User.class, UserDto.class).map(user);
    }

    @Override
    public void registerUser(UserDto user) {
        Log.d("registerUser called. User = %s", user.toString());
        userRepository.saveUser(Mapper.createTypeMap(UserDto.class, User.class).map(user));
    }

    @Override
    public UserDto findUserById(long userId) {
        Log.d("FindUserById called. UserId = %d", userId);
        return Mapper.createTypeMap(User.class, UserDto.class).map(userRepository.getUserById(userId));
    }

    @Override
    public Iterable<UserDto> getAllUsers() {
        Log.d("GetAllUsers called.");
        Set<User> users = new HashSet<>(userRepository.getAllUsers());
        TypeMap<User, UserDto> mapper = Mapper.createTypeMap(User.class, UserDto.class);

        return users.stream()
                .map(mapper::map)
                .collect(Collectors.toSet());
    }
}
