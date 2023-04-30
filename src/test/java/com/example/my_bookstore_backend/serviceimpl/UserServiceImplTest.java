package com.example.my_bookstore_backend.serviceimpl;

import com.example.my_bookstore_backend.Dao.UserDao;
import com.example.my_bookstore_backend.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {
    private UserServiceImpl userService;

    @Mock
    private UserDao userDao;


    @BeforeEach
    void setUp() {
        userService = new UserServiceImpl();
        userService.setUserDao(userDao);
    }

    @Test
    void save() {
        User user = new User();
        userService.save(user);
        verify(userDao).save(user);
    }

    @Test
    void auth() {
        User user = new User();
        user.setName("hello");
        user.setPassword("world");
        when(userDao.auth("hello", "world")).thenReturn(user);
        Assertions.assertEquals(user, userService.auth(user.getName(), user.getPassword()));
    }

    @Test
    void getAllUsers() {
        ArrayList<User> users = new ArrayList<>();
        when(userDao.getAllUsers()).thenReturn(users);
        Assertions.assertEquals(users, userService.getAllUsers());
    }

    @Test
    void getUserById() {
        User user = new User();
        user.setUid(0);
        when(userDao.getUserById(user.getUid())).thenReturn(user);
        Assertions.assertEquals(user, userService.getUserById(user.getUid()));
    }

    @Test
    void checkUser() {
        User user = new User();
        user.setName("hello");
        user.setUid(1);
        when(userDao.getUserByName(user.getName())).thenReturn(user);
        Assertions.assertEquals(1, userService.checkUser(user.getName()));
        when(userDao.getUserByName("empty")).thenReturn(null);
        Assertions.assertEquals(0, userService.checkUser("empty"));
    }

    @Test
    void setstate() {
        when(userDao.setstate(1, 1)).thenReturn(1);
        Assertions.assertEquals(1, userService.setstate(1, 1));
    }
}