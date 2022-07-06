package com.example.my_bookstore_backend.controller;

import com.alibaba.fastjson.JSON;
import com.example.my_bookstore_backend.entity.*;
import com.example.my_bookstore_backend.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/cartItem")
public class CartItemController {
    @Autowired
    private CartItemService cartItemService;

    @PostMapping(path = "/add")
    //Only add one by one
    public CartItem addNewCartItem(@RequestParam int uid, @RequestParam int bid) {
        return cartItemService.addNewCartItem(uid, bid);
    }

    @PostMapping(path = "/delete")
    //Only delete one by one
    public CartItem deleteCartItem(@RequestParam int uid, @RequestParam int bid) {
        return cartItemService.deleteCartItem(uid, bid);
    }

    @GetMapping(path = "/all")
    public Iterable<CartItem> getAll() {
        return cartItemService.getAll();
    }

    @PostMapping(path = "/search")
    public CartItem getByOIid(@RequestParam int ciid) {
        CartItem c = cartItemService.getByOIid(ciid);
        if (c == null)
        {
            c = new CartItem();
            c.setCartItemId(0);
            return c;
        }
        return c;
    }

    @GetMapping(path = "/getAllCartItems")
    public List<CartItem> getAllCartItemsByUid(@RequestParam Integer uid) {
        return cartItemService.getAllCartItemsByUid(uid);
    }

}
