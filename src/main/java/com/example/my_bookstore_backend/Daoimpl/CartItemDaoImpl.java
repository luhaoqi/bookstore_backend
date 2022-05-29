package com.example.my_bookstore_backend.Daoimpl;

import com.example.my_bookstore_backend.Dao.CartItemDao;
import com.example.my_bookstore_backend.entity.*;
import com.example.my_bookstore_backend.repository.BookRepository;
import com.example.my_bookstore_backend.repository.CartItemRepository;
import com.example.my_bookstore_backend.repository.CartRepository;
import com.example.my_bookstore_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class CartItemDaoImpl implements CartItemDao {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private CartItemRepository cartItemRepository;


    @Override
    public CartItem addNewCartItem(int uid, int bid) {
        Optional<Book> book = bookRepository.findById(bid);
        if (book.isEmpty()) return null;
        Optional<User> user = userRepository.findById(uid);
        if (user.isEmpty()) return null;
        Cart cart = user.get().getCart();

        int newPrice = cart.getPrice() + book.get().getPrice();
        //如果有 +1
        List<CartItem> t = cartItemRepository.findByCartAndBook(cart, book.get());
        if (t.size() > 0) {
            assert (t.size() == 1);
            CartItem c = t.get(0);
            c.setNum(c.getNum() + 1);
            cartItemRepository.save(c);
            cart.setPrice(newPrice);
            cartRepository.save(cart);
            return c;
        }
        //如果没有 新建 num=1
        CartItem cartItem = new CartItem();
        cartItem.setBook(book.get());
        cartItem.setCart(cart);
        cartItem.setNum(1);
        cartItemRepository.save(cartItem);
        cart.setPrice(newPrice);
        cartRepository.save(cart);
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
        Cart cart = user.get().getCart();
        int newPrice = cart.getPrice() + book.get().getPrice();
        //如果有 -1
        List<CartItem> t = cartItemRepository.findByCartAndBook(cart, book.get());
        if (t.size() > 0) {
            assert (t.size() == 1);
            CartItem c = t.get(0);
            //如果多于一个;
            if (c.getNum() > 1) {
                c.setNum(c.getNum() - 1);
                cartItemRepository.save(c);
                cart.setPrice(newPrice);
                cartRepository.save(cart);
//                return JSON.toJSONString(c);
                return c;
            }
            //只剩一个就直接删掉;
            cartItemRepository.delete(c);
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
        List<Cart> carts = cartRepository.getByUid(user.get());
        assert (carts.size() == 1);
        Cart cart = carts.get(0);
        return cartItemRepository.findBycart(cart);
    }

    @Override
    public List<CartItem> getByCid(int cid) {
        //use l as null
        CartItem o = new CartItem();
        o.setCartItemId(0);
        List<CartItem> l = new ArrayList<>();
        l.add(o);

        Optional<Cart> cart = cartRepository.findById(cid);
        if (cart.isEmpty()) return l;
        return cartItemRepository.findBycart(cart.get());
    }
}
