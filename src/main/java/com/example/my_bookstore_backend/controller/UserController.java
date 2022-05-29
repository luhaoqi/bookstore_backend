package com.example.my_bookstore_backend.controller;

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
                              @RequestParam String address) {


        User user = new User();
        user.setName(name);
        user.setPassword(password);
        user.setEmail(email);
        user.setTel(tel);
        user.setAddress(address);

        Cart cart = new Cart();
        cart.setPrice(0);
        cart.setUser(user);

        user.setCart(cart);

//        userRepository.save(user);
        userService.save(user);
        return user.getUid();
    }

    @PostMapping(path = "/auth")
    public int checkUser(@RequestParam String name, @RequestParam String password) {
//        return userRepository.auth(name, password).getUid();
        return userService.auth(name, password).getUid();
    }

    @GetMapping(path = "/all")
    public Iterable<User> getAllUsers() {
//        return userRepository.findAll();
        return userService.getAllUsers();
    }

    @PostMapping(path = "/search")
    public User getByUid(@RequestParam Integer uid) {
//        Optional<User> x = userRepository.findById(uid);
//        if (x.isPresent()) return x.get();
//        return null;
        return userService.getUserById(uid);
    }

}
