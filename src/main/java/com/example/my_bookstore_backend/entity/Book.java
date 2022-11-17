package com.example.my_bookstore_backend.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;

import lombok.Data;
import org.apache.solr.client.solrj.beans.Field;

@Data
@Entity
@Table(name = "books")
@JsonIgnoreProperties(value = {"handler","hibernateLazyInitializer","fieldHandler"})
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "bid")
public class Book {

    @Id
    @Column(name = "bid")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Field("id")
    private int bid;

    @Field("name")
    private String name;
    @Field("author")
    private String author;
    private int price;
    private String image;
    private int sales;
    private int stock;

    @Field("description")
    private String description;

    private String isbn;
    private int flag;
}

