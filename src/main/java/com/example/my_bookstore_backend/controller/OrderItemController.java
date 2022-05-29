package com.example.my_bookstore_backend.controller;

import com.example.my_bookstore_backend.entity.Book;
import com.example.my_bookstore_backend.entity.OrderItem;
import com.example.my_bookstore_backend.entity.OrderList;
import com.example.my_bookstore_backend.entity.User;
import com.example.my_bookstore_backend.repository.BookRepository;
import com.example.my_bookstore_backend.repository.OrderItemRepository;
import com.example.my_bookstore_backend.repository.OrderListRepository;
import com.example.my_bookstore_backend.repository.UserRepository;
import com.example.my_bookstore_backend.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.List;

@RestController
@RequestMapping(path = "/orderItem")
public class OrderItemController {
    @Autowired
    private OrderItemService orderItemService;

    @PostMapping(path = "/add")
    public int addNewOrderItem(@RequestParam int bid, @RequestParam int oid, @RequestParam int num) {
        return orderItemService.addNewOrderItem(bid, oid, num);
    }

    @GetMapping(path = "/all")
    public Iterable<OrderItem> getAllOrderLists() {
        return orderItemService.getAllOrderLists();
    }

    @PostMapping(path = "/search")
    public OrderItem getByOIid(@RequestParam Integer oiid) {
        return orderItemService.getByOIid(oiid);
    }

    @PostMapping(path = "/getByOid")
    public List<OrderItem> getByOid(@RequestParam Integer oid) {
        return orderItemService.getByOid(oid);
    }
}
