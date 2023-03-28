package com.example.my_bookstore_backend.Daoimpl;

import com.example.my_bookstore_backend.Dao.BookDao;
import com.example.my_bookstore_backend.entity.Book;
import com.example.my_bookstore_backend.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BookDaoImpl implements BookDao {

    private BookRepository bookRepository;

    @Autowired
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void save(Book b) {
        bookRepository.save(b);
    }

    public void delete(Book b) {
        b.setFlag(0);
        bookRepository.save(b);
    }

    @Override
    public Iterable<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBookById(int id) {
        return bookRepository.findByBid(id);
    }
}
