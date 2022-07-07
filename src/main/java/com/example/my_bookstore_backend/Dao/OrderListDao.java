package com.example.my_bookstore_backend.Dao;

import com.example.my_bookstore_backend.DTO.OrderListDTO;
import com.example.my_bookstore_backend.entity.OrderList;

import java.util.List;

public interface OrderListDao {

    int addNewOrderList(int uid, int price, String time);

    Iterable<OrderList> getAllOrderLists();

    OrderList getByOid(int oid);

    List<OrderList> getByUid(int uid);

    OrderList purchase(int uid, String tel, String address, String name);
}
