package com.example.my_bookstore_backend.controller;

import com.example.my_bookstore_backend.entity.OrderList;
import com.example.my_bookstore_backend.service.OrderListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/order")
public class OrderListController {

    @Autowired
    private OrderListService orderListService;

    //基本不用 购物车购买直接调用purchase
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
    public OrderList purchase(@RequestParam int uid, @RequestParam String tel,
                              @RequestParam String address, @RequestParam String name) {
        OrderList o = orderListService.purchase(uid, tel, address, name);
        if (o != null) return o;
        o = new OrderList();
        o.setOrderListId(0);
        return o;
    }


}