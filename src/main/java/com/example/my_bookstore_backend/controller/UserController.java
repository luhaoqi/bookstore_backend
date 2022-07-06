package com.example.my_bookstore_backend.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.my_bookstore_backend.entity.Cart;
import com.example.my_bookstore_backend.entity.User;
import com.example.my_bookstore_backend.repository.CartItemRepository;
import com.example.my_bookstore_backend.repository.CartRepository;
import com.example.my_bookstore_backend.repository.OrderItemRepository;
import com.example.my_bookstore_backend.repository.OrderListRepository;
import com.example.my_bookstore_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        Integer exist = userService.checkUser(name);
        if (exist != 0) return 0;

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
