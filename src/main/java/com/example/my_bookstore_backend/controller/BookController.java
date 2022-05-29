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

/**
 * @ClassName BookController
 * @Description Book Controller
 * @Author HaoqiLu
 * @Date 2022/5/13
 */

@RestController
@RequestMapping(path = "/book")
public class BookController {

    @Autowired
//    private BookRepository bookRepository;
    private BookService bookService;

    @PostMapping(path = "/add")
    public Integer addNewUser(@RequestParam String name, @RequestParam String author,
                              @RequestParam int price, @RequestParam String image,
                              @RequestParam String description, @RequestParam String isbn,
                              @RequestParam Integer sales) {
        Book book = new Book();
        book.setAuthor(author);
        book.setName(name);
        book.setPrice(price);
        book.setImage(image);
        book.setSales(sales);
        book.setDescription(description);
        book.setIsbn(isbn);
//        bookRepository.save(book);
        bookService.save(book);
        return book.getBid();
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
