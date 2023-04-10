package com.example.my_bookstore_backend.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "books")
@JsonIgnoreProperties(value = {"handler", "hibernateLazyInitializer", "fieldHandler"})
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "bid")
public class Book {

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    @Id
    @Column(name = "bid")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int bid;


    private String name;
    private String author;
    private int price;
    private String image;
    private int sales;
    private int stock;

    private String description;

    private String isbn;
    private int flag;
}

