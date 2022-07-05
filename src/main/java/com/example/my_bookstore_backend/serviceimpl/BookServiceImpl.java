package com.example.my_bookstore_backend.serviceimpl;

import com.example.my_bookstore_backend.Dao.BookDao;
import com.example.my_bookstore_backend.entity.Book;
import com.example.my_bookstore_backend.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    @Override
    public void save(Book b) {
        bookDao.save(b);
    }

    @Override
    public void delete(Book b) {
        bookDao.delete(b);
    }

    @Override
    public Iterable<Book> getAllBooks(){
        return bookDao.getAllBooks();
    }

    @Override
    public Book getBookById(int id){
        return bookDao.getBookById(id);
    }

}
