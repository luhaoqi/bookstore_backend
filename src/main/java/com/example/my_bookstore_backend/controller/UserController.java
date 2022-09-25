package com.example.my_bookstore_backend.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.my_bookstore_backend.entity.User;
import com.example.my_bookstore_backend.repository.CartItemRepository;
import com.example.my_bookstore_backend.repository.OrderItemRepository;
import com.example.my_bookstore_backend.repository.OrderListRepository;
import com.example.my_bookstore_backend.service.TimerService;
import com.example.my_bookstore_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;

@RestController
@RequestMapping(path = "/user")
@Scope("singleton")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private TimerService timerService;

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
        timerService.start();
        data.put("uid", u.getUid());
        data.put("state", u.getState());
        return data;
    }

    @GetMapping(path = "/logout")
    public JSONObject logout() {
        timerService.end();
        JSONObject data = new JSONObject();
        data.put("start", timerService.getStartTime());
        data.put("end", timerService.getEndTime());
        data.put("total",timerService.getTime());
        return data;
    }

    @GetMapping(path = "/all")
    public Iterable<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping(path = "/exist")
    public Integer checkUser(@RequestParam String username) {
        return userService.checkUser(username);
    }

    @PostMapping(path = "/search")
    public User getByUid(@RequestParam Integer uid) {
        return userService.getUserById(uid);
    }

    @PostMapping(path = "/setstate")
    public int getByUid(@RequestParam int uid, @RequestParam int s) {
        return userService.setstate(uid, s);
    }

}
