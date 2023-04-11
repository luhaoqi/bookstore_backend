package com.example.my_bookstore_backend.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.my_bookstore_backend.entity.User;
import com.example.my_bookstore_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping(path = "/user")
public class UserController {
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(path = "/add")
    public Integer addNewUser(@RequestParam String name, @RequestParam String password,
                              @RequestParam String email, @RequestParam String tel,
                              @RequestParam(defaultValue = "") String address) {
        Integer exist = userService.checkUser(name);
        if (exist != 0) return 0;

        User user = new User();
        user.setName(name);
        user.setPassword(password);
        user.setEmail(email);
        user.setTel(tel);
        user.setAddress(address);
        user.setState(1);
        user.setCartItemList(new ArrayList<>());

        userService.save(user);
        return user.getUid();
    }

    @PostMapping(path = "/auth")
    public JSONObject checkUser(@RequestParam String name,
                                @RequestParam String password) {
        User u = userService.auth(name, password);
        JSONObject data = new JSONObject();
        if (u == null) {
            data.put("uid", 0);
            data.put("state", 0);
            return data;
        }
        data.put("uid", u.getUid());
        data.put("state", u.getState());
        return data;
    }

    @GetMapping(path = "/all")
    public Iterable<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping(path = "/exist")
    public Integer checkUserExist(@RequestParam String username) {
        return userService.checkUser(username);
    }

    @PostMapping(path = "/search")
    public User getByUid(@RequestParam Integer uid) {
        return userService.getUserById(uid);
    }

    @PostMapping(path = "/setstate")
    public int setState(@RequestParam int uid, @RequestParam int s) {
        return userService.setstate(uid, s);
    }

}
