package com.example.my_bookstore_backend.Dao;

import com.example.my_bookstore_backend.entity.Book;

public interface BookDao {

    void save(Book b);

    void delete(Book b);

    Iterable<Book> getAllBooks();

    Book getBookById(int id);
}
