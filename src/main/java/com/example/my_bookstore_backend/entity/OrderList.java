package com.example.my_bookstore_backend.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name = "OrderLists")
@JsonIgnoreProperties(value = {"handler","hibernateLazyInitializer","fieldHandler"})
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "orderListId")
public class OrderList {

    @Id
    @Column(name = "orderListId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int orderListId;
    private int price;
    private String time;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;


}
