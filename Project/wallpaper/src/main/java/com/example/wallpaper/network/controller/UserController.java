package com.example.wallpaper.network.controller;

import com.example.wallpaper.core.service.contract.UserService;
import com.example.wallpaper.data.model.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/users")
    Iterable<UserDto> getUsers(){
        return userService.getAllUsers();
    }
}
