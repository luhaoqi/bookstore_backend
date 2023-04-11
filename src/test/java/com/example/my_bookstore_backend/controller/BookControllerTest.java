package com.example.my_bookstore_backend.controller;

import com.example.my_bookstore_backend.entity.Book;
import com.example.my_bookstore_backend.service.BookService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BookControllerTest {
    @Mock
    private BookService bookService;

    private final BookController bookController = new BookController();

    @BeforeEach
    void setUp() {
        bookController.setBookService(bookService);
    }

    String name = "123";
    String author = "aaa";
    int price = 111;
    String image = "www.baidu.com";
    String description = "111";
    String isbn = "123s";
    int sales = 111;
    int stock = 22;
    int flag = 1;

    Book createBook(int bid) {
        Book book = new Book();
        book.setBid(bid);
        book.setName(name);
        book.setAuthor(author);
        book.setPrice(price);
        book.setImage(image);
        book.setDescription(description);
        book.setIsbn(isbn);
        book.setSales(sales);
        book.setStock(stock);
        book.setFlag(flag);
        return book;
    }

    @Test
    void addNewBook() {
        int bid = 0;

        Book book = createBook(bid);

        assertEquals(bookController.addNewBook(name, author, price, image, description, isbn, sales, stock), book.getBid());
        verify(bookService).save(book);
    }

    @Test
    void editBook() {
        int bid = 1;

        Book book = createBook(bid);
        Book book_null = new Book();
        book_null.setBid(0);

        when(bookService.getBookById(bid)).thenReturn(book);
        when(bookService.getBookById(-1)).thenReturn(null);

        assertEquals(bookController.editBook(-1, name, author, price, image, description, isbn, sales, stock), book_null);

        assertEquals(bookController.editBook(bid, name, author, price, image, description, isbn, sales, stock), book);
        verify(bookService).save(book);
    }

    @Test
    void deleteBook() {
        int bid = 1;

        Book book = createBook(bid);
        when(bookService.getBookById(bid)).thenReturn(book);
        when(bookService.getBookById(-1)).thenReturn(null);

        assertEquals(bookController.deleteBook(-1), 0);
        assertEquals(bookController.deleteBook(bid), 1);
        verify(bookService).delete(book);
    }

    @Test
    void getBooks() {
        int bid = 1;

        List<Book> list = new ArrayList<>();
        Book book = createBook(bid);
        list.add(book);
        when(bookService.getAllBooks()).thenReturn(list);

        assertEquals(bookController.getBooks(), list);
    }

    @Test
    void getBookByID() {
        int bid = 1;

        Book book = createBook(bid);
        Book book_null = new Book();
        book_null.setBid(0);
        when(bookService.getBookById(bid)).thenReturn(book);
        when(bookService.getBookById(-1)).thenReturn(book_null);

        assertEquals(bookController.getBookByID(-1), book_null);
        assertEquals(bookController.getBookByID(bid), book);
    }
}