package com.example.my_bookstore_backend.Daoimpl;

import com.example.my_bookstore_backend.Dao.BookDao;
import com.example.my_bookstore_backend.entity.Book;
import com.example.my_bookstore_backend.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class BookDaoImpl implements BookDao {

    @Autowired
    private BookRepository bookRepository;

    @Transactional(propagation = Propagation.REQUIRED)
    public void save(Book b) {
//        int a = 10 / 0;
        bookRepository.save(b);
    }

    public void delete(Book b) {
        b.setFlag(0);
        bookRepository.save(b);
//        bookRepository.delete(b);
    }

    @Override
    public Iterable<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBookById(int id) {
        Book b = bookRepository.findByBid(id);
        return b;
    }
}
