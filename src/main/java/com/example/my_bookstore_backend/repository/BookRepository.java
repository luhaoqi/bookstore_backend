package com.example.my_bookstore_backend.repository;

import com.example.my_bookstore_backend.entity.Book;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface BookRepository extends CrudRepository<Book, Integer> {

    @Modifying
    @Transactional
    @Query("delete from Book b where b.bid = :bid")
    void REMOVE(int bid);

    Book findByBid(Integer bid);

    List<Book> findAll();
}
