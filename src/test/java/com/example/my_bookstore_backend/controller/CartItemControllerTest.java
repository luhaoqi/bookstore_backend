package com.example.my_bookstore_backend.controller;

import com.example.my_bookstore_backend.entity.Book;
import com.example.my_bookstore_backend.entity.CartItem;
import com.example.my_bookstore_backend.entity.User;
import com.example.my_bookstore_backend.service.CartItemService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CartItemControllerTest {

    @Mock
    private CartItemService cartItemService;

    private final CartItemController cartItemController = new CartItemController();

    @BeforeEach
    void setUp(){ cartItemController.setCartItemService(cartItemService);}

    // Book meta data
    static String book_name = "123";
    static String book_author = "aaa";
    static int book_price = 111;
    static String book_image = "www.baidu.com";
    static String book_description = "111";
    static String book_isbn = "123s";
    static int book_sales = 111;
    static int book_stock = 22;
    static int book_flag = 1;

    static Book createBook(int bid){
        Book book = new Book();
        book.setBid(bid);
        book.setName(book_name);
        book.setAuthor(book_author);
        book.setPrice(book_price);
        book.setImage(book_image);
        book.setDescription(book_description);
        book.setIsbn(book_isbn);
        book.setSales(book_sales);
        book.setStock(book_stock);
        book.setFlag(book_flag);
        return book;
    }

    static CartItem createCartItem(int cartItemId, Book book, User user, Integer num){
        return new CartItem(cartItemId, book, user, num);
    }

    static User createUser(String name, String password, int uid) {
        User user = new User();
        user.setName(name);
        user.setPassword(password);
        user.setUid(uid);
        return user;
    }

    @Test
    void addNewCartItem(){
        Book book1 = createBook(1);
        User user1 = createUser("tzm", "112233", 1);
        CartItem cartItem1 = cartItemController.addNewCartItem(user1.getUid(), book1.getBid());
        verify(cartItemService).addNewCartItem(user1.getUid(), book1.getBid());
    }

    @Test
    void deleteCartItem(){
        Book book1 = createBook(1);
        User user1 = createUser("tzm", "112233", 1);
        CartItem cartItem1 = createCartItem(11, book1, user1, 200);

        when(cartItemService.deleteCartItem(user1.getUid(), book1.getBid())).thenReturn(cartItem1);
        assertEquals(cartItemController.deleteCartItem(user1.getUid(), book1.getBid()), cartItem1);
        verify(cartItemService).deleteCartItem(user1.getUid(), book1.getBid());
    }

    @Test
    void getAll(){
        Book book1 = createBook(1);
        User user1 = createUser("tzm", "112233", 1);
        CartItem cartItem1 = createCartItem(11, book1, user1, 200);

        List<CartItem> list = new ArrayList<>();
        list.add(cartItem1);
        when(cartItemService.getAll()).thenReturn(list);

        assertEquals(cartItemController.getAll(), list);
    }

    @Test
    void getByOIid(){
        Book book1 = createBook(1);
        User user1 = createUser("tzm", "112233", 1);
        CartItem cartItem1 = createCartItem(11, book1, user1, 200);
        int ciid_null = 20;
        CartItem null_cartItem = new CartItem();
        null_cartItem.setCartItemId(0);

        when(cartItemService.getByOIid(cartItem1.getCartItemId())).thenReturn(cartItem1);
        when(cartItemService.getByOIid(ciid_null)).thenReturn(null);

        assertEquals(cartItemController.getByOIid(cartItem1.getCartItemId()), cartItem1);
        assertEquals(cartItemController.getByOIid(ciid_null), null_cartItem);
    }

    @Test
    void getAllCartItemsByUid(){
        Book book1 = createBook(1);
        User user1 = createUser("tzm", "112233", 1);
        User user2 = createUser("hjb", "112233", 2);
        CartItem cartItem1 = createCartItem(11, book1, user1, 200);
        CartItem cartItem2 = createCartItem(12, book1, user2, 250);

        List<CartItem> list = new ArrayList<>();
        list.add(cartItem1);
        when(cartItemService.getAllCartItemsByUid(user1.getUid())).thenReturn(list);
        assertEquals(cartItemController.getAllCartItemsByUid(user1.getUid()), list);
    }

}
