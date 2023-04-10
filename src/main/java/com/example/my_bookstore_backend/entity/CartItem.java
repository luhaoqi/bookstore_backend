package com.example.my_bookstore_backend.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "cart_items")
@JsonIgnoreProperties(value = {"handler", "hibernateLazyInitializer", "fieldHandler"})
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "cartItemId")
public class CartItem {

    public CartItem() {}

    public CartItem(int cartItemId, Book book, User user, Integer num) {
        this.book = book;
        this.cartItemId = cartItemId;
        this.num = num;
        this.user = user;
    }


    @Id
    @Column(name = "cart_item_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int cartItemId;

    @ManyToOne
    @JoinColumn(name = "bid")
    private Book book;


    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "uid")
    private User user;

    private Integer num;

}