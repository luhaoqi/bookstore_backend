package com.example.my_bookstore_backend.repository;

import com.example.my_bookstore_backend.entity.OrderItem;
import com.example.my_bookstore_backend.entity.OrderList;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderItemRepository extends CrudRepository<OrderItem, Integer> {
    @Query("select oi from OrderItem oi where oi.orderList=:orderList")
    List<OrderItem> getAllByOrderList(OrderList orderList);
}
