package com.example.my_bookstore_backend.serviceimpl;

import com.example.my_bookstore_backend.Dao.UserDao;
import com.example.my_bookstore_backend.entity.User;
import com.example.my_bookstore_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;


    @Override
    public void save(User u) {
        userDao.save(u);
    }

    @Override
    public User auth(String name, String password) {
        return userDao.auth(name, password);
    }

    @Override
    public Iterable<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public User getUserById(int uid) {
        return userDao.getUserById(uid);
    }

    @Override
    public Integer checkUser(String username) {
        return userDao.getUserByName(username);
    }

    @Override
    public int setstate(int uid, int s) {
        return userDao.setstate(uid, s);
    }
}
