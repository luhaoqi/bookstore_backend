package com.example.my_bookstore_backend.repository;

import com.example.my_bookstore_backend.entity.Book;
import com.example.my_bookstore_backend.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


public interface BookRepository extends CrudRepository<Book, Integer> {

    @Modifying
    @Transactional
    @Query("delete from Book b where b.bid = :bid")
    void REMOVE(int bid);
}
