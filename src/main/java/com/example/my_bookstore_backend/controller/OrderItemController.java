package com.example.my_bookstore_backend.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.my_bookstore_backend.entity.Book;
import com.example.my_bookstore_backend.entity.OrderItem;
import com.example.my_bookstore_backend.entity.OrderList;
import com.example.my_bookstore_backend.entity.User;
import com.example.my_bookstore_backend.repository.BookRepository;
import com.example.my_bookstore_backend.repository.OrderItemRepository;
import com.example.my_bookstore_backend.repository.OrderListRepository;
import com.example.my_bookstore_backend.repository.UserRepository;
import com.example.my_bookstore_backend.service.OrderItemService;
import com.example.my_bookstore_backend.service.OrderListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;
import java.util.List;

@RestController
@RequestMapping(path = "/orderItem")
public class OrderItemController {
    @Autowired
    private OrderItemService orderItemService;

    @Autowired
    private OrderListService orderListService;

    @PostMapping(path = "/add")
    public int addNewOrderItem(@RequestParam int bid, @RequestParam int oid, @RequestParam int num) {
        return orderItemService.addNewOrderItem(bid, oid, num);
    }

    @GetMapping(path = "/all")
    public Iterable<JSONObject> getAllOrderLists() {
        //        return orderItemService.getAllOrderLists();
        Iterable<OrderItem> x = orderItemService.getAllOrderLists();
        List<JSONObject> list = new ArrayList<>();
        for (OrderItem oi : x) {
            JSONObject data = new JSONObject();
            OrderList o = oi.getOrderList();

            data.put("orderListId", o.getOrderListId());
            data.put("price", o.getPrice());
            data.put("time", o.getTime());
            data.put("uid", o.getUser().getUid());
            data.put("username", o.getUser().getName());
            data.put("bookname", oi.getBook().getName());
            data.put("bookprice", oi.getBook().getPrice());
            list.add(data);
        }
        return list;
    }

    @PostMapping(path = "/search")
    public OrderItem getByOIid(@RequestParam Integer oiid) {
        return orderItemService.getByOIid(oiid);
    }

    @PostMapping(path = "/getByOid")
    public List<OrderItem> getByOid(@RequestParam Integer oid) {
        return orderItemService.getByOid(oid);
    }

    @PostMapping(path = "/getByUid")
    public List<JSONObject> getByUid(@RequestParam int uid) {
        List<OrderList> orderlist = orderListService.getByUid(uid);
        List<JSONObject> res = new ArrayList<>();
        for (OrderList x : orderlist) {
            List<OrderItem> oiList = orderItemService.getByOid(x.getOrderListId());
            for (OrderItem oi : oiList) {
                JSONObject data = new JSONObject();

                data.put("orderListId", x.getOrderListId());
                data.put("orderItemId", oi.getOrderItemId());
                data.put("bookname", oi.getBook().getName());
                data.put("bookprice", oi.getBook().getPrice());
                data.put("price", x.getPrice());
                data.put("time", x.getTime());
                data.put("num",oi.getNum());
                res.add(data);
            }
        }
        return res;
    }
}
