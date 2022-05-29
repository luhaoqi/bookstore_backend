package com.example.my_bookstore_backend.repository;

import com.example.my_bookstore_backend.entity.*;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CartItemRepository extends CrudRepository<CartItem, Integer> {
    @Query("select ci from CartItem ci where ci.cart=:cart")
    List<CartItem> findBycart(Cart cart);

    @Query("select ci from CartItem ci where ci.cart=:cart and ci.book=:book")
    List<CartItem> findByCartAndBook(Cart cart, Book book);
    @Modifying
    @Transactional
    @Query("delete from CartItem ci where ci.cart = :cart")
    void clear(Cart cart);
}
