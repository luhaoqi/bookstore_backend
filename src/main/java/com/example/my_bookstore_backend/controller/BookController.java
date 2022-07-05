package com.example.my_bookstore_backend.controller;

import com.example.my_bookstore_backend.entity.Book;
import com.example.my_bookstore_backend.entity.User;
import com.example.my_bookstore_backend.repository.BookRepository;
import com.example.my_bookstore_backend.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.ArrayList;
import java.util.Iterator;

@RestController
@RequestMapping(path = "/book")
public class BookController {

    @Autowired
//    private BookRepository bookRepository;
    private BookService bookService;
    @Autowired
    private BookRepository bookRepository;

    @PostMapping(path = "/add")
    public int addNewBook(@RequestParam String name, @RequestParam String author,
                          @RequestParam int price, @RequestParam String image,
                          @RequestParam String description, @RequestParam String isbn,
                          @RequestParam int sales, @RequestParam int stock) {
        Book book = new Book();
        book.setAuthor(author);
        book.setName(name);
        book.setPrice(price);
        book.setImage(image);
        book.setSales(sales);
        book.setDescription(description);
        book.setIsbn(isbn);
        book.setStock(stock);
//        bookRepository.save(book);
        bookService.save(book);
        return book.getBid();
    }

    @PostMapping(path = "/edit")
    public int editBook(@RequestParam int bid,
                        @RequestParam String name, @RequestParam String author,
                        @RequestParam String isbn, @RequestParam int stock) {
        Book book = bookService.getBookById(bid);
        book.setAuthor(author);
        book.setName(name);
        book.setIsbn(isbn);
        book.setStock(stock);
//        bookRepository.save(book);
        bookService.save(book);
        return book.getBid();
    }

    @PostMapping(path = "/delete")
    public int editBook(@RequestParam int bid) {
        Book book = bookService.getBookById(bid);
        if (book != null)
        {
            bookRepository.REMOVE(book.getBid());
            return 1;
        }
        return 0;
    }

    @GetMapping("/all")
    public Iterable<Book> getBooks() {
//        System.out.println(bookRepository.findAll());
//        return bookRepository.findAll();
        return bookService.getAllBooks();
    }

    @PostMapping("/search")
    public Book getBookByID(@RequestParam("id") Integer id) {
//        Optional<Book> book = bookRepository.findById(id);
//        return book.get();
        return bookService.getBookById(id);
    }
}
