package com.example.my_bookstore_backend.Daoimpl;

import com.example.my_bookstore_backend.entity.Book;
import com.example.my_bookstore_backend.repository.BookRepository;
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
public class BookDaoImplTest {
    private final BookDaoImpl bookDao = new BookDaoImpl();

    @Mock
    private BookRepository bookRepository;

    @BeforeEach
    void beforeEach() {
        bookDao.setBookRepository(bookRepository);
    }

    @Test
    void save() {
        Book book = new Book();
        bookDao.save(book);
        verify(bookRepository).save(book);
    }

    @Test
    void delete() {
        Book book = new Book();
        book.setFlag(1);
        bookDao.delete(book);
        Assertions.assertEquals(0, book.getFlag());
        verify(bookRepository).save(book);
    }

    @Test
    void getAllBooks() {
        ArrayList<Book> books = new ArrayList<>();
        when(bookRepository.findAll()).thenReturn(books);
        Assertions.assertEquals(books, bookDao.getAllBooks());
    }

    @Test
    void getBookById() {
        Book book = new Book();
        book.setBid(0);
        when(bookRepository.findByBid(book.getBid())).thenReturn(book);
        Assertions.assertEquals(book, bookDao.getBookById(book.getBid()));
        when(bookRepository.findByBid(-1)).thenReturn(null);
        Assertions.assertNull(bookDao.getBookById(-1));

    }
}
