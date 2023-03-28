package com.example.my_bookstore_backend.repository;

import com.example.my_bookstore_backend.entity.OrderList;
import com.example.my_bookstore_backend.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderListRepository extends CrudRepository<OrderList, Integer> {
    @Query("select o from OrderList o where o.user=:user")
    List<OrderList> getAllByUid(User user);
}
