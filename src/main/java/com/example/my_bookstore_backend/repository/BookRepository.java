package com.example.my_bookstore_backend.repository;

import com.example.my_bookstore_backend.entity.Book;
import org.springframework.data.repository.CrudRepository;


public interface BookRepository extends CrudRepository<Book, Integer> {

    Book findByBid(Integer bid);
}
