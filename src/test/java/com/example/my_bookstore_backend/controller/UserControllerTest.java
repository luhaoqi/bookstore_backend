package com.example.my_bookstore_backend.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.my_bookstore_backend.entity.User;
import com.example.my_bookstore_backend.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {
    private final UserController userController = new UserController();
    String name = "wjr";
    String password = "123456";
    String tel = "13712341234";
    String email = "123@qq.com";
    String address = "China";
    @Mock
    private UserService userService;

    @BeforeEach
    void setUp() {
        userController.setUserService(userService);
    }

    User createUser(int uid) {
        User user = new User();
        user.setUid(uid);
        user.setName(name);
        user.setPassword(password);
        user.setTel(tel);
        user.setEmail(email);
        user.setAddress(address);
        user.setState(1);
        user.setCartItemList(new ArrayList<>());
        return user;
    }

    @Test
    void addNewUser() {
        int uid = 0;
        User user = createUser(uid);

        when(userService.checkUser(name)).thenReturn(0);
        when(userService.checkUser("xxx")).thenReturn(1);

        assertEquals(userController.addNewUser("xxx", password, email, tel, address), 0);
        assertEquals(userController.addNewUser(name, password, email, tel, address), 0);
        verify(userService).save(user);
    }

    @Test
    void checkUser() {
        int uid = 1;
        User user = createUser(uid);
        when(userService.auth(name, password)).thenReturn(user);
        when(userService.auth(name, "password")).thenReturn(null);

        JSONObject data = new JSONObject();
        JSONObject data_null = new JSONObject();
        data_null.put("uid", 0);
        data_null.put("state", 0);
        data.put("uid", user.getUid());
        data.put("state", user.getState());
        assertEquals(userController.checkUser(name, "password"), data_null);
        assertEquals(userController.checkUser(name, password), data);
    }

    @Test
    void getAllUsers() {
        int uid = 1;
        List<User> list = new ArrayList<>();
        User user = createUser(uid);
        list.add(user);

        when(userService.getAllUsers()).thenReturn(list);
        assertEquals(userController.getAllUsers(), list);
    }

    @Test
    void checkUserExist() {
        when(userService.checkUser(name)).thenReturn(0);
        when(userService.checkUser("xxx")).thenReturn(1);
        assertEquals(userController.checkUserExist(name), 0);
        assertEquals(userController.checkUserExist("xxx"), 1);
    }

    @Test
    void getByUid() {
        int uid = 1;
        User user = createUser(uid);
        when(userService.getUserById(uid)).thenReturn(user);
        assertEquals(userController.getByUid(uid), user);
    }

    @Test
    void setState() {
        int uid = 1;
        User user = createUser(uid);
        when(userService.setstate(uid, 0)).thenReturn(1);
        assertEquals(userController.setState(uid, 0), 1);
    }
}