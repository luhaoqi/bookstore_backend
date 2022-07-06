package com.example.my_bookstore_backend.controller;

import com.example.my_bookstore_backend.entity.Book;
import com.example.my_bookstore_backend.repository.BookRepository;
import com.example.my_bookstore_backend.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//永远不要返回null 做好特判
@RestController
@RequestMapping(path = "/book")
public class BookController {

    @Autowired
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
        bookService.save(book);
        return book.getBid();
    }

    @PostMapping(path = "/edit")
    public Book editBook(@RequestParam int bid,
                         @RequestParam(required = false) String name, @RequestParam(required = false) String author,
                         @RequestParam(required = false) Integer price, @RequestParam(required = false) String image,
                         @RequestParam(required = false) String description, @RequestParam(required = false) String isbn,
                         @RequestParam(required = false) Integer sales, @RequestParam(required = false) Integer stock) {
        Book book = bookService.getBookById(bid);
        if (book == null) {
            Book nullBook = new Book();
            nullBook.setBid(0);
            return nullBook;
        }
        if (name != null) book.setName(name);
        if (author != null) book.setAuthor(author);
        if (price != null) book.setPrice(price);
        if (image != null) book.setImage(image);
        if (description != null) book.setDescription(description);
        if (isbn != null) book.setIsbn(isbn);
        if (sales != null) book.setSales(sales);
        if (stock != null) book.setStock(stock);
        bookService.save(book);
        return book;
    }

    @PostMapping(path = "/delete")
    public int editBook(@RequestParam int bid) {
        Book book = bookService.getBookById(bid);
        if (book != null) {
            bookService.delete(book);
            return 1;
        }
        return 0;
    }

    @GetMapping("/all")
    public Iterable<Book> getBooks() {
        return bookService.getAllBooks();
    }

    @PostMapping("/search")
    public Book getBookByID(@RequestParam("id") Integer id) {
        Book book = bookService.getBookById(id);
        if (book == null) {
            Book nullBook = new Book();
            nullBook.setBid(0);
            return nullBook;
        }
        return book;
    }
}
