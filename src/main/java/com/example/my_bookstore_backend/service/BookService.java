package com.example.my_bookstore_backend.service;

import com.example.my_bookstore_backend.entity.Book;

import java.util.List;

public interface BookService {

    void save(Book b, String iconBase64);

    void delete(Book b);

    List<Book> getAllBooks();

    Book getBookById(int id);
}
