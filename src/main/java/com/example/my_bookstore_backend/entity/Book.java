package com.example.my_bookstore_backend.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;

import lombok.Data;
/**
 * @ClassName Book
 * @Description Book Entity
 * @Author HaoqiLu
 * @Date 2022/5/13 16:50
 */

@Data
@Entity
@Table(name = "Books")
@JsonIgnoreProperties(value = {"handler","hibernateLazyInitializer","fieldHandler"})
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "bid")
public class Book {

    @Id
    @Column(name = "bid")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int bid;


    private String name;
    private String author;
    private int price;
    private String image;
    private int sales;

    private String description;
//    private Integer inventory;
    private String isbn;
//    private String type;
}

