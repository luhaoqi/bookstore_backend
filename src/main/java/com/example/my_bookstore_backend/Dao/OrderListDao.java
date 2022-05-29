package com.example.my_bookstore_backend.Dao;

import com.example.my_bookstore_backend.entity.OrderList;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface OrderListDao {

    public int addNewOrderList(int uid, int price, String time);

    public Iterable<OrderList> getAllOrderLists();

    public OrderList getByOid(int oid);

    public List<OrderList> getByUid(int uid);

    public String purchase(int uid);
}
