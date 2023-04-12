package com.example.my_bookstore_backend.Daoimpl;

import com.example.my_bookstore_backend.entity.Book;
import com.example.my_bookstore_backend.entity.CartItem;
import com.example.my_bookstore_backend.entity.OrderList;
import com.example.my_bookstore_backend.entity.User;
import com.example.my_bookstore_backend.repository.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OrderListDaoImplTest {
    private final OrderListDaoImpl orderListDao = new OrderListDaoImpl();
    private final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//定义新的日期格式
    @Mock
    CartItemRepository cartItemRepository;
    @Mock
    OrderItemRepository orderItemRepository;
    @Mock
    BookRepository bookRepository;
    @Mock
    private UserRepository userRepository;
    @Mock
    private OrderListRepository orderListRepository;

    @BeforeEach
    void setUp() {
        orderListDao.setBookRepository(bookRepository);
        orderListDao.setOrderItemRepository(orderItemRepository);
        orderListDao.setOrderListRepository(orderListRepository);
        orderListDao.setCartItemRepository(cartItemRepository);
        orderListDao.setUserRepository(userRepository);
    }

    @Test
    void addNewOrderList() {
        int uid = 1;
        int price = 123123;
        String time = "2022-1-12 13:00:00";
        User user = new User();
        user.setUid(uid);
        when(userRepository.findById(user.getUid())).thenReturn(Optional.of(user));
        OrderList orderList = new OrderList();
        orderList.setUser(user);
        orderList.setTime(time);
        orderList.setPrice(price);
        assertEquals(orderListDao.addNewOrderList(uid, price, time), 0);
        verify(orderListRepository).save(orderList);

        assertEquals(orderListDao.addNewOrderList(-1, price, time), 0);
    }

    @Test
    void getAllOrderLists() {
        ArrayList<OrderList> orderLists = new ArrayList<>();
        when(orderListRepository.findAll()).thenReturn(orderLists);
        assertEquals(orderListDao.getAllOrderLists(), orderLists);
    }

    @Test
    void getByOid() {
        int oid = 1;
        OrderList orderlist = new OrderList();
        orderlist.setOrderListId(oid);
        when(orderListRepository.findById(oid)).thenReturn(Optional.of(orderlist));
        assertEquals(orderListDao.getByOid(oid), orderlist);

        orderlist.setOrderListId(0);
        assertEquals(orderListDao.getByOid(-1), orderlist);
    }

    @Test
    void getByUid() {
        int uid = 1;
        User user = new User();
        user.setUid(uid);
        when(userRepository.findById(uid)).thenReturn(Optional.of(user));
        when(userRepository.findById(-1)).thenReturn(Optional.empty());

        List<OrderList> list = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            OrderList orderlist = new OrderList();
            orderlist.setOrderListId(i);
            orderlist.setUser(user);
            list.add(orderlist);
        }
        when(orderListRepository.getAllByUid(user)).thenReturn(list);

        assertEquals(orderListDao.getByUid(user.getUid()), list);

        Assertions.assertNull(orderListDao.getByUid(-1));
    }

    @Test
    void purchase() {
        int tot = 0;
        List<CartItem> list = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            CartItem cartItem = new CartItem();
            cartItem.setCartItemId(i);
            cartItem.setNum(i);
            Book book = new Book();
            book.setBid(i);
            book.setSales(10 * i);
            book.setStock(10 * i);
            book.setPrice(i);
            tot += i * book.getPrice();

            cartItem.setBook(book);
            list.add(cartItem);
        }

        int uid = 1;
        User user = new User();
        user.setUid(uid);
        user.setCartItemList(list);
        when(userRepository.findById(uid)).thenReturn(Optional.of(user));
        when(userRepository.findById(-1)).thenReturn(Optional.empty());
        Assertions.assertNull(orderListDao.purchase(-1, "", "", ""));

        String tel = "13712341234";
        String address = "China";
        String name = "lhq";
        OrderList orderList = new OrderList();
        orderList.setName(name);
        orderList.setTel(tel);
        orderList.setAddress(address);

        String dateString = formatter.format(new Date());
        orderList.setTime(dateString);
        orderList.setPrice(tot);
        orderList.setUser(user);

        OrderList _orderlist = orderListDao.purchase(uid, tel, address, name);
        _orderlist.setTime(dateString);
        assertEquals(_orderlist, orderList);

        //库存不足
        for (CartItem x : list) {
            x.setNum(10000);
        }
        when(userRepository.findById(uid)).thenReturn(Optional.of(user));
        _orderlist = orderListDao.purchase(uid, tel, address, name);
        assertNull(_orderlist);
    }
}