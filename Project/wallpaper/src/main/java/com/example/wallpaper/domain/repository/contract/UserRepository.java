package com.example.wallpaper.domain.repository.contract;

import com.example.wallpaper.domain.entity.User;

import java.util.List;

public interface UserRepository {

    void saveUser(User user);

    User getUserById(Long id);

    List<User> getAllUsers();

    Iterable<String> getAllEmails();

    User getUserByEmail(String email);
}
