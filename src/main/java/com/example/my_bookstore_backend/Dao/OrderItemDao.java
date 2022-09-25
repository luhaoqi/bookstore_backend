package com.example.my_bookstore_backend.Dao;

import com.example.my_bookstore_backend.entity.OrderItem;

import java.util.List;

public interface OrderItemDao {
    void save(OrderItem o);

    int addNewOrderItem(int bid, int oid, int num);

    Iterable<OrderItem> getAllOrderLists();

    OrderItem getByOIid(int oiid);

    List<OrderItem> getByOid(int oid);

}
