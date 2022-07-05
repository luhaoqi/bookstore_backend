package com.example.my_bookstore_backend.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.my_bookstore_backend.entity.*;
import com.example.my_bookstore_backend.repository.*;
import com.example.my_bookstore_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.ArrayList;
import java.util.Iterator;

@RestController
@RequestMapping(path = "/user")
public class UserController {
    @Autowired
//    private UserRepository userRepository;
    private UserService userService;

    @Autowired
    private OrderListRepository orderListRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CartItemRepository cartItemRepository;

    @PostMapping(path = "/add")
    public Integer addNewUser(@RequestParam String name, @RequestParam String password,
                              @RequestParam String email, @RequestParam String tel,
                              @RequestParam(defaultValue = "") String address) {


        User user = new User();
        user.setName(name);
        user.setPassword(password);
        user.setEmail(email);
        user.setTel(tel);
        user.setAddress(address);
        user.setState(1);

        Cart cart = new Cart();
        cart.setPrice(0);
        cart.setUser(user);

        user.setCart(cart);

//        userRepository.save(user);
        userService.save(user);
        return user.getUid();
    }

    @PostMapping(path = "/auth")
    public JSONObject checkUser(@RequestParam String name,
                                @RequestParam String password) {
        User u=userService.auth(name, password);
        JSONObject data = new JSONObject();
        if (u==null) {
            data.put("uid",0);
            data.put("state",0);
            return data;
        }
        data.put("uid",u.getUid());
        data.put("state",u.getState());
        return data;
    }

    @GetMapping(path = "/all")
    public Iterable<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping(path = "/search")
    public User getByUid(@RequestParam Integer uid) {
        return userService.getUserById(uid);
    }

    @PostMapping(path = "/setstate")
    public int getByUid(@RequestParam int uid,@RequestParam int s) {
        return userService.setstate(uid,s);
    }

}
