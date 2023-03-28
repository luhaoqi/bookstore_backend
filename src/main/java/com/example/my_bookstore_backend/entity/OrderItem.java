package com.example.my_bookstore_backend.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "order_items")
@JsonIgnoreProperties(value = {"handler", "hibernateLazyInitializer", "fieldHandler"})
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "orderItemId")
public class OrderItem {

    @Id
    @Column(name = "order_item_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int orderItemId;

    @ManyToOne
    @JoinColumn(name = "bid")
    private Book book;

    @ManyToOne
    @JoinColumn(name = "order_list_id")
    @JsonIgnore
    private OrderList orderList;

    private int num;

    private int price;
}