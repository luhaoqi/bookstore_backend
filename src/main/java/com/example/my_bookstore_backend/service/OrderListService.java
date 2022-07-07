package com.example.my_bookstore_backend.service;

import com.example.my_bookstore_backend.DTO.OrderListDTO;
import com.example.my_bookstore_backend.entity.OrderList;

import java.util.List;

public interface OrderListService {
    int addNewOrderList(int uid, int price, String time);

    Iterable<OrderList> getAllOrderLists();

    OrderList getByOid(int oid);

    List<OrderList> getByUid(int uid);

    OrderList purchase(int uid, String tel, String address, String name);
}
