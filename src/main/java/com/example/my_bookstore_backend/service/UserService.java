package com.example.my_bookstore_backend.service;

import com.example.my_bookstore_backend.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    void save(User u);

    User auth(String name, String password);

    Iterable<User> getAllUsers();

    User getUserById(int uid);

    int setstate(int uid, int s);
}
