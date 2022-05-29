package com.example.my_bookstore_backend.service;

import com.example.my_bookstore_backend.entity.User;

public interface UserService {
    void save(User u);

    User auth(String name, String password);

    Iterable<User> getAllUsers();

    User getUserById(int uid);
}
