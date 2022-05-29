package com.example.my_bookstore_backend.Dao;

import com.example.my_bookstore_backend.entity.OrderItem;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface OrderItemDao {

    public int addNewOrderItem(int bid, int oid, int num);

    public Iterable<OrderItem> getAllOrderLists();

    public OrderItem getByOIid(int oiid);

    public List<OrderItem> getByOid(int oid);

}
