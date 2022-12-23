package com.example.my_bookstore_backend.entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "BookIcon")
public class BookIcon {

    private int bid;

    private String iconBase64;

    public BookIcon(int bid, String iconBase64) {
        this.bid = bid;
        this.iconBase64 = iconBase64;
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int x) {
        this.bid = x;
    }

    public String getIconBase64() {
        return iconBase64;
    }

    public void setIconBase64(String iconBase64) {
        this.iconBase64 = iconBase64;
    }
}
