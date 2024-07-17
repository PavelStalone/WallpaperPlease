package com.example.wallpaper.domain.repository.contract;

import com.example.wallpaper.domain.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DefaultUserRepository extends DefaultRepository<User> {

    User findByEmail(String email);

    @Query(value = "SELECT u.email FROM User u")
    Iterable<String> getAllEmails();
}
