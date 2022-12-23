package com.example.my_bookstore_backend.Daoimpl;

import com.alibaba.fastjson.JSONArray;
import com.example.my_bookstore_backend.Dao.BookDao;
import com.example.my_bookstore_backend.entity.Book;
import com.example.my_bookstore_backend.entity.BookIcon;
import com.example.my_bookstore_backend.repository.BookIconRepository;
import com.example.my_bookstore_backend.repository.BookRepository;
import com.example.my_bookstore_backend.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public class BookDaoImpl implements BookDao {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private BookIconRepository bookIconRepository;
    @Autowired
    RedisUtil redisUtil;

    @Transactional(propagation = Propagation.REQUIRED)
    public void save(Book b, String iconBase64) {
//        int a = 10 / 0;
        bookRepository.save(b);
        redisUtil.set("book:" + b.getBid(), JSONArray.toJSON(b));
        redisUtil.set("book:all", "del");

        BookIcon bookIcon = new BookIcon(b.getBid(), iconBase64);
        bookIconRepository.save(bookIcon);
    }

    public void save(Book b) {
//        int a = 10 / 0;
        bookRepository.save(b);
//        redisUtil.set("book:" + b.getBid(), JSONArray.toJSON(b));
//        redisUtil.set("book:all", "del");

    }

    public void delete(Book b) {
        b.setFlag(0);
        bookRepository.save(b);
//        bookRepository.delete(b);
//        redisUtil.set("book:" + b.getBid(), JSONArray.toJSON(b));
//        redisUtil.set("book:all", "del");
    }

    @Override
    public List<Book> getAllBooks() {
        List<Book> list = null;
//        System.out.println("Searching All Books in Redis");
//        Object p = redisUtil.get("book:all");
//        if (p == null || Objects.equals(p.toString(), "del")) {
//            System.out.println(p == null ? "find null books" : "find del mask");
        list = bookRepository.findAll();
//            redisUtil.set("book:all", JSONArray.toJSON(list));
//            System.out.println("get books from DB");
//        } else {
//            System.out.println(p);
//
//            list = new ArrayList<>();
//            if (p instanceof List<?>) {
//                for (Object o : (List<?>) p) {
//                    list.add(JSONArray.parseObject(o.toString(), Book.class));
//                }
//            }
//
//            System.out.println("Book all is in Redis ");
//        }
//        for (Book b : list) System.out.println(b);
        for (Book b : list) {
            Optional<BookIcon> icon = bookIconRepository.findByBid(b.getBid());
            if (icon.isPresent()) {
                System.out.println("Not Null " + b.getBid());
                b.setBookIcon(icon.get());
            } else {
                b.setBookIcon(null);
                System.out.println("It's Null");
            }
        }
        return list;
    }

    @Override
    public Book getBookById(int id) {
        Book b = null;
//        System.out.println("Searching Book: " + id + " in Redis");
//        Object p = redisUtil.get("book:" + id);
//        if (p == null) {
//        System.out.println("Book: " + id + " is not in Redis");
        System.out.println("Searching Book: " + id + " in DB");
        b = bookRepository.findByBid(id);
        Optional<BookIcon> icon = bookIconRepository.findByBid(b.getBid());
        if (icon.isPresent()) {
            System.out.println("Not Null " + b.getBid());
            b.setBookIcon(icon.get());
        } else {
            b.setBookIcon(null);
            System.out.println("It's Null");
        }

        System.out.println(b);
//        redisUtil.set("book:" + id, JSONArray.toJSON(b));
//        } else {
//            b = JSONArray.parseObject(p.toString(), Book.class);
//            System.out.println("Book: " + id + " is in Redis");
//        }
        return b;
    }
}
