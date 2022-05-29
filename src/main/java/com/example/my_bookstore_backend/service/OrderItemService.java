package com.example.my_bookstore_backend.service;

import com.example.my_bookstore_backend.entity.OrderItem;

import java.util.List;

public interface OrderItemService {
    public int addNewOrderItem(int bid, int oid, int num);

    public Iterable<OrderItem> getAllOrderLists();

    public OrderItem getByOIid(int oiid);

    public List<OrderItem> getByOid(int oid);
}
