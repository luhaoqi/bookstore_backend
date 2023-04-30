package com.example.my_bookstore_backend.serviceimpl;

import com.example.my_bookstore_backend.Dao.BookDao;
import com.example.my_bookstore_backend.entity.Book;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BookServiceImplTest {

    private BookServiceImpl bookService;

    @Mock
    private BookDao bookDao;

    static Book createBook(int bid) {
        Book book = new Book();
        book.setBid(bid);
        return book;
    }

    @BeforeEach
    void setUp() {
        bookService = new BookServiceImpl();
        bookService.setBookDao(bookDao);
    }

    @Test
    void save() {
        Book book = createBook(0);
        bookService.save(book);
        verify(bookDao).save(book);
    }

    @Test
    void delete() {
        Book book = createBook(0);
        bookService.delete(book);
        verify(bookDao).delete(book);
    }

    @Test
    void getAllBooks() {
        ArrayList<Book> books = new ArrayList<>();
        books.add(createBook(0));
        books.add(createBook(1));
        when(bookDao.getAllBooks()).thenReturn(books);
        Assertions.assertEquals(bookService.getAllBooks(), books);
    }

    @Test
    void getBookById() {

        Book book = createBook(0);
        when(bookDao.getBookById(0)).thenReturn(book);
        Assertions.assertEquals(bookService.getBookById(0), book);
    }
}
