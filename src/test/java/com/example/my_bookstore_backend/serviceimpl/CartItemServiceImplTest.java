package com.example.my_bookstore_backend.serviceimpl;

import com.example.my_bookstore_backend.Dao.CartItemDao;
import com.example.my_bookstore_backend.entity.CartItem;
import com.example.my_bookstore_backend.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CartItemServiceImplTest {

    private CartItemServiceImpl cartItemService;
    @Mock
    private CartItemDao cartItemDao;


    @BeforeEach
    void setUp() {
        cartItemService = new CartItemServiceImpl();
        cartItemService.setCartItemDao(cartItemDao);
    }


    @Test
    void addNewCartItem() {
        CartItem cartItem = new CartItem();
        when(cartItemDao.addNewCartItem(1, 2)).thenReturn(cartItem);
        Assertions.assertEquals(cartItem, cartItemService.addNewCartItem(1, 2));
    }

    @Test
    void deleteCartItem() {
        CartItem cartItem = new CartItem();
        when(cartItemDao.deleteCartItem(1, 2)).thenReturn(cartItem);
        Assertions.assertEquals(cartItem, cartItemService.deleteCartItem(1, 2));
    }

    @Test
    void getAll() {
        ArrayList<CartItem> cartItems = new ArrayList<>();
        when(cartItemDao.getAll()).thenReturn(cartItems);
        Assertions.assertEquals(cartItems, cartItemService.getAll());
    }

    @Test
    void getByOIid() {
        CartItem cartItem = new CartItem();
        cartItem.setCartItemId(0);
        when(cartItemDao.getByOIid(cartItem.getCartItemId())).thenReturn(cartItem);
        Assertions.assertEquals(cartItem, cartItemService.getByOIid(cartItem.getCartItemId()));

    }

    @Test
    void getAllCartItemsByUid() {
        ArrayList<CartItem> cartItems = new ArrayList<>();
        CartItem cartItem = new CartItem();
        User user = new User();
        user.setUid(0);
        cartItem.setUser(user);
        cartItems.add(cartItem);
        when(cartItemDao.getAllCartItemsByUid(cartItem.getUser().getUid())).thenReturn(cartItems);
        Assertions.assertEquals(cartItems, cartItemService.getAllCartItemsByUid(user.getUid()));
    }
}