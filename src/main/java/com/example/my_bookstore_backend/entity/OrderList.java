package com.example.my_bookstore_backend.entity;

import com.example.my_bookstore_backend.DTO.OrderListDTO;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Data
@Entity
@Table(name = "order_lists")
@JsonIgnoreProperties(value = {"handler", "hibernateLazyInitializer", "fieldHandler"})
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "orderListId")
public class OrderList {

    @Id
    @Column(name = "order_list_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int orderListId;
    private int price;
    private String time;
    private String tel;
    private String address;
    private String name;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(targetEntity = OrderItem.class, mappedBy = "orderList",
            cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<OrderItem> orderItemList;

    public OrderListDTO ToOrderListDTO() {
        OrderListDTO data = new OrderListDTO();
        data.setOrderList(this);
        List<String> list = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        List<Integer> list3 = new ArrayList<>();
        for (OrderItem x : orderItemList) {
            list.add(x.getBook().getName());
            list2.add(x.getNum());
            list3.add(x.getPrice());
        }
        data.setBookName(list);
        data.setBookSales(list2);
        data.setBookPrice(list3);
        data.setUsername(user.getName());
        data.setUid(user.getUid());
        return data;
    }
}