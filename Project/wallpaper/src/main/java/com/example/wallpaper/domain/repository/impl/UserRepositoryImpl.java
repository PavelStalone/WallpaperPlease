package com.example.wallpaper.domain.repository.impl;

import com.example.wallpaper.domain.entity.User;
import com.example.wallpaper.domain.repository.contract.DefaultUserRepository;
import com.example.wallpaper.domain.repository.contract.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryImpl extends BaseRepository<DefaultUserRepository> implements UserRepository {

    @Override
    public void saveUser(User user) {
        repository.save(user);
    }

    @Override
    public User getUserById(Long id) {
        return repository.getReferenceById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return repository.findAll();
    }

    @Override
    public Iterable<String> getAllEmails() {
        return repository.getAllEmails();
    }

    @Override
    public User getUserByEmail(String email) {
        return repository.findByEmail(email);
    }
}
