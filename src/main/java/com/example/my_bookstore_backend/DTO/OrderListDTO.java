package com.example.my_bookstore_backend.DTO;

import com.example.my_bookstore_backend.entity.OrderList;
import lombok.Data;

import java.util.List;

@Data
public class OrderListDTO {
    OrderList orderList;
    String username;
    Integer uid;
    private List<String> bookName;
    private List<Integer> bookSales;
    private List<Integer> bookPrice;
}
