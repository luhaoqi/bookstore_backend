package com.example.my_bookstore_backend.Daoimpl;

import com.example.my_bookstore_backend.entity.Book;
import com.example.my_bookstore_backend.entity.CartItem;
import com.example.my_bookstore_backend.entity.User;
import com.example.my_bookstore_backend.repository.BookRepository;
import com.example.my_bookstore_backend.repository.CartItemRepository;
import com.example.my_bookstore_backend.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CartItemDaoImplTest {

    private final CartItemDaoImpl cartItemDao = new CartItemDaoImpl();

    @Mock
    private CartItemRepository cartItemRepository;

    @Mock
    private UserRepository userRepository;

    @Mock
    private BookRepository bookRepository;

    static User createUser(String name, String password, int uid) {
        User user = new User();
        user.setName(name);
        user.setPassword(password);
        user.setUid(uid);
        return user;
    }

    @BeforeEach
    void setUp() {
        cartItemDao.setCartItemRepository(cartItemRepository);
        cartItemDao.setBookRepository(bookRepository);
        cartItemDao.setUserRepository(userRepository);
    }

    @Test
    void addNewCartItem() {
        // hjb has book, not book2;
        // wjr is invalid user
        // _book is invalid book
        User user = createUser("hjb", "123456", 1);
        User _user = createUser("wjr", "123456", 2);
        Book book = new Book(); book.setBid(1);
        Book book2 = new Book(); book2.setBid(2);
        Book _book = new Book(); book2.setBid(3);
        when(bookRepository.findById(book.getBid())).thenReturn(Optional.of(book));
        when(bookRepository.findById(book2.getBid())).thenReturn(Optional.of(book2));
        when(bookRepository.findById(_book.getBid())).thenReturn(Optional.empty());
        when(userRepository.findById(user.getUid())).thenReturn(Optional.of(user));
        when(userRepository.findById(_user.getUid())).thenReturn(Optional.empty());
        CartItem target = new CartItem(1, book, user, 1);
        CartItem target2 = new CartItem(2, book, user, 2);
        when(cartItemRepository.findByUserAndBook(user, book))
                .thenReturn(target);
        // test one
        cartItemDao.addNewCartItem(user.getUid(), book.getBid());
        verify(cartItemRepository).save(target);
        //Assertions.assertEquals(cartItemDao.addNewCartItem(user.getUid(), book.getBid()), target2);
        // test two
        Assertions.assertNull(cartItemDao.addNewCartItem(_user.getUid(), book.getBid()));
        // test three
        Assertions.assertNull(cartItemDao.addNewCartItem(user.getUid(), _book.getBid()));

        // test four
        CartItem cartItem = new CartItem();
        cartItem.setBook(book2);
        cartItem.setNum(1);
        cartItem.setUser(user);
        cartItemDao.addNewCartItem(user.getUid(), book2.getBid());
        verify(cartItemRepository).save(cartItem);

    }

    @Test
    void deleteCartItem() {
        CartItem nullc = new CartItem();
        nullc.setCartItemId(0);
        User user = createUser("hjb", "123456", 1);
        User _user = createUser("wjr", "123456", 2);
        Book book = new Book(); book.setBid(1);
        Book book2 = new Book(); book2.setBid(2);
        Book _book = new Book(); book2.setBid(3);
        when(bookRepository.findById(book.getBid())).thenReturn(Optional.of(book));
        when(bookRepository.findById(book2.getBid())).thenReturn(Optional.of(book2));
        when(bookRepository.findById(_book.getBid())).thenReturn(Optional.empty());
        when(userRepository.findById(user.getUid())).thenReturn(Optional.of(user));
        when(userRepository.findById(_user.getUid())).thenReturn(Optional.empty());
        CartItem target = new CartItem(1, book, user, 1);
        CartItem target2 = new CartItem(2, book, user, 2);
        when(cartItemRepository.findByUserAndBook(user, book))
                .thenReturn(target);
        // Assertion1 invalid user
        Assertions.assertEquals(cartItemDao.deleteCartItem(_user.getUid(), book.getBid()), nullc);
        // Assertion2 invalid book
        Assertions.assertEquals(cartItemDao.deleteCartItem(user.getUid(), _book.getBid()), nullc);
        // test3  -1 workflow
        when(cartItemRepository.findByUserAndBook(user, book)).thenReturn(target2);
        cartItemDao.deleteCartItem(user.getUid(), book.getBid());
        verify(cartItemRepository).save(target2);
        // test4 delete workflow
        when(cartItemRepository.findByUserAndBook(user, book)).thenReturn(target);
        cartItemDao.deleteCartItem(user.getUid(), book.getBid());
        verify(cartItemRepository).delete(target);
        // test5 no carItem
        when(cartItemRepository.findByUserAndBook(user, book2)).thenReturn(null);
        Assertions.assertEquals(cartItemDao.deleteCartItem(user.getUid(), book2.getBid()), nullc);
    }

    @Test
    void getAll() {
    }

    @Test
    void getByOIid() {
    }

    @Test
    void getAllCartItemsByUid() {
    }
}