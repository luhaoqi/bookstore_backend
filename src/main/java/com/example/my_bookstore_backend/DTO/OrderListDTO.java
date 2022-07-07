package com.example.my_bookstore_backend.DTO;

import com.example.my_bookstore_backend.entity.OrderItem;
import com.example.my_bookstore_backend.entity.OrderList;
import com.example.my_bookstore_backend.entity.User;
import lombok.Data;

import java.util.List;
@Data
public class OrderListDTO {
    OrderList orderList;
    private List<String> bookName;
    String username;
    Integer uid;
}
