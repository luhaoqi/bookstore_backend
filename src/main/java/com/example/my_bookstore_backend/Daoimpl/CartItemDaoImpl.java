package com.example.my_bookstore_backend.Daoimpl;

import com.example.my_bookstore_backend.Dao.CartItemDao;
import com.example.my_bookstore_backend.entity.Book;
import com.example.my_bookstore_backend.entity.CartItem;
import com.example.my_bookstore_backend.entity.User;
import com.example.my_bookstore_backend.repository.BookRepository;
import com.example.my_bookstore_backend.repository.CartItemRepository;
import com.example.my_bookstore_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class CartItemDaoImpl implements CartItemDao {
    private BookRepository bookRepository;
    private UserRepository userRepository;
    private CartItemRepository cartItemRepository;

    @Autowired
    void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Autowired
    void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public void setCartItemRepository(CartItemRepository cartItemRepository) {
        this.cartItemRepository = cartItemRepository;
    }

    @Override
    public CartItem addNewCartItem(int uid, int bid) {
        Optional<Book> book = bookRepository.findById(bid);
        if (book.isEmpty()) return null;
        Optional<User> user = userRepository.findById(uid);
        if (user.isEmpty()) return null;

        //如果有 +1
        CartItem t = cartItemRepository.findByUserAndBook(user.get(), book.get());
        if (t != null) {
            t.setNum(t.getNum() + 1);
            cartItemRepository.save(t);
            return t;
        }
        //如果没有 新建 num=1
        CartItem cartItem = new CartItem();
        cartItem.setBook(book.get());
        cartItem.setNum(1);
        cartItem.setUser(user.get());
        cartItemRepository.save(cartItem);
        return cartItem;
    }

    @Override
    public CartItem deleteCartItem(int uid, int bid) {
        CartItem nullc = new CartItem();
        nullc.setCartItemId(0);
        //use c as null;

        Optional<Book> book = bookRepository.findById(bid);
        if (book.isEmpty()) return nullc;
        Optional<User> user = userRepository.findById(uid);
        if (user.isEmpty()) return nullc;
        //如果有 -1
        CartItem t = cartItemRepository.findByUserAndBook(user.get(), book.get());
        if (t != null) {
            //如果多于一个;
            if (t.getNum() > 1) {
                t.setNum(t.getNum() - 1);
                cartItemRepository.save(t);
                return t;
            }
            //只剩一个就直接删掉;
            cartItemRepository.delete(t);
            return nullc;
        }
        //如果没有 返回null;
        return nullc;
    }

    @Override
    public Iterable<CartItem> getAll() {
        return cartItemRepository.findAll();
    }

    @Override
    public CartItem getByOIid(int ciid) {
        Optional<CartItem> x = cartItemRepository.findById(ciid);
        if (x.isPresent()) return x.get();

        CartItem nullc = new CartItem();
        nullc.setCartItemId(0);
        //use c as null;
        return nullc;
    }

    @Override
    public List<CartItem> getAllCartItemsByUid(int uid) {
        //use l as null
        CartItem o = new CartItem();
        o.setCartItemId(0);
        List<CartItem> l = new ArrayList<>();
        l.add(o);

        Optional<User> user = userRepository.findById(uid);
        if (user.isEmpty()) return l;
        return cartItemRepository.findByUser(user.get());
    }

}
