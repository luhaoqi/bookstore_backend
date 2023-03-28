package com.example.my_bookstore_backend.Dao;

import com.example.my_bookstore_backend.entity.User;

public interface UserDao {
    void save(User u);

    User auth(String name, String password);

    Iterable<User> getAllUsers();

    User getUserById(int uid);

    User getUserByName(String username);

    int setstate(int uid, int s);
}
