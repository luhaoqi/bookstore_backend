package com.example.my_bookstore_backend.Dao;

import com.example.my_bookstore_backend.entity.OrderList;

import java.util.List;

public interface OrderListDao {
    void save(OrderList o);

    int addNewOrderList(int uid, int price, String time);

    Iterable<OrderList> getAllOrderLists();

    OrderList getByOid(int oid);

    List<OrderList> getByUid(int uid);

}
