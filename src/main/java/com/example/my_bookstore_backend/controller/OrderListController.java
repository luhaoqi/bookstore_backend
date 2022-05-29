package com.example.my_bookstore_backend.controller;

import com.example.my_bookstore_backend.entity.Cart;
import com.example.my_bookstore_backend.entity.OrderList;
import com.example.my_bookstore_backend.entity.User;
import com.example.my_bookstore_backend.repository.CartItemRepository;
import com.example.my_bookstore_backend.repository.OrderListRepository;
import com.example.my_bookstore_backend.repository.UserRepository;
import com.example.my_bookstore_backend.service.OrderListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/order")
public class OrderListController {

    @Autowired
    private OrderListService orderListService;

    @PostMapping(path = "/add")
    public int addNewOrderList(@RequestParam int uid, @RequestParam int price, @RequestParam String time) {
        return orderListService.addNewOrderList(uid, price, time);
    }

    @GetMapping(path = "/all")
    public Iterable<OrderList> getAllOrderLists() {
        return orderListService.getAllOrderLists();
    }

    @PostMapping(path = "/search")
    public OrderList getByOid(@RequestParam int oid) {
        return orderListService.getByOid(oid);
    }

    @GetMapping(path = "/getByUid")
    public List<OrderList> getByUid(@RequestParam int uid) {
        return orderListService.getByUid(uid);
    }

    @PostMapping(path = "/purchase")
    public String purchase(@RequestParam int uid) {
        return orderListService.purchase(uid);
    }


}