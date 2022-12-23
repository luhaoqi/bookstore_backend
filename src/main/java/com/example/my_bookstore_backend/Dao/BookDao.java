package com.example.my_bookstore_backend.Dao;

import com.example.my_bookstore_backend.entity.Book;

import java.util.List;

public interface BookDao {

    void save(Book b, String iconBase64);

    void save(Book b);

    void delete(Book b);

    List<Book> getAllBooks();

    Book getBookById(int id);
}
