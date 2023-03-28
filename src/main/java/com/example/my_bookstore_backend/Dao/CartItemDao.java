package com.example.my_bookstore_backend.Dao;

import com.example.my_bookstore_backend.entity.CartItem;

import java.util.List;

public interface CartItemDao {
    //Only add one by one
    public CartItem addNewCartItem(int uid, int bid);

    //Only delete one by one
    public CartItem deleteCartItem(int uid, int bid);

    public Iterable<CartItem> getAll();

    public CartItem getByOIid(int ciid);

    public List<CartItem> getAllCartItemsByUid(int uid);

}
