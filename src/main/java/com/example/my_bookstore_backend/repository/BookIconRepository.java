package com.example.my_bookstore_backend.repository;

import com.example.my_bookstore_backend.entity.BookIcon;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface BookIconRepository  extends MongoRepository<BookIcon, Integer> {
    Optional<BookIcon> findByBid(int bid);
}
