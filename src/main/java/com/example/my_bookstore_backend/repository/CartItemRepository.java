package com.example.my_bookstore_backend.repository;

import com.example.my_bookstore_backend.entity.Book;
import com.example.my_bookstore_backend.entity.CartItem;
import com.example.my_bookstore_backend.entity.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CartItemRepository extends CrudRepository<CartItem, Integer> {
    @Modifying
    @Transactional
    @Query("delete from CartItem ci where ci.user = :user")
    void clear(User user);

    List<CartItem> findByUser(User user);

    CartItem findByUserAndBook(User user, Book book);
}
