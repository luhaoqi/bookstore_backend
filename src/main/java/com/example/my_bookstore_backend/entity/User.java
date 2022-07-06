package com.example.my_bookstore_backend.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "users")
@JsonIgnoreProperties(value = {"handler", "hibernateLazyInitializer", "fieldHandler"})
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "uid")
public class User {

    @Id
    @Column(name = "uid")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int uid;
    private String name;
    private String password;
    private String email;
    private String tel;
    private String address;
    private int state; //0:封禁 1:普通用户 2:admin

    @JsonIgnore
    @OneToMany(targetEntity = CartItem.class, mappedBy = "user",
            cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<CartItem> cartItemList;

    @JsonIgnore
    @OneToMany(targetEntity = OrderList.class, mappedBy = "user",
            cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<OrderList> orderLists;

}
