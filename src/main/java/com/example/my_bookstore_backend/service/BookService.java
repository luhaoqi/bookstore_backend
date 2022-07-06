package com.example.my_bookstore_backend.service;

import com.example.my_bookstore_backend.entity.Book;

public interface BookService {

    void save(Book b);

    void delete(Book b);

    Iterable<Book> getAllBooks();

    Book getBookById(int id);
}
