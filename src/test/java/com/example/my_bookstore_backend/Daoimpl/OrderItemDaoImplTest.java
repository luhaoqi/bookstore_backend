package com.example.my_bookstore_backend.Daoimpl;

import com.example.my_bookstore_backend.entity.Book;
import com.example.my_bookstore_backend.entity.OrderItem;
import com.example.my_bookstore_backend.entity.OrderList;
import com.example.my_bookstore_backend.repository.BookRepository;
import com.example.my_bookstore_backend.repository.OrderItemRepository;
import com.example.my_bookstore_backend.repository.OrderListRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OrderItemDaoImplTest {
    private final OrderItemDaoImpl orderItemDao = new OrderItemDaoImpl();
    @Mock
    private OrderItemRepository orderItemRepository;
    @Mock
    private BookRepository bookRepository;
    @Mock
    private OrderListRepository orderListRepository;

    @BeforeEach
    void setUp() {
        orderItemDao.setBookRepository(bookRepository);
        orderItemDao.setOrderItemRepository(orderItemRepository);
        orderItemDao.setOrderListRepository(orderListRepository);
    }

    static Book createBook(int bid){
        Book book = new Book();
        book.setBid(bid);
        return book;
    }

    static OrderList createOrderList(int oid){
        OrderList orderList = new OrderList();
        orderList.setOrderListId(oid);
        return orderList;
    }

    static OrderItem createOrderItem(Book book, OrderList orderList, int num){
        OrderItem orderItem = new OrderItem();
        orderItem.setBook(book);
        orderItem.setOrderList(orderList);
        orderItem.setNum(num);
        return orderItem;
    }

    @Test
    void addNewOrderItem() {
        int bid = 1, oid = 1, num = 3;

        Book book = createBook(bid);
        Optional<Book> optionalBook = Optional.of(book);
        when(bookRepository.findById(book.getBid())).thenReturn(optionalBook);

        OrderList orderList = createOrderList(oid);
        Optional<OrderList> optionalOrderList = Optional.of(orderList);
        when(orderListRepository.findById(oid)).thenReturn(optionalOrderList);

        OrderItem orderItem = createOrderItem(book, orderList, num);

        Assertions.assertEquals(orderItemDao.addNewOrderItem(bid, oid, num), orderItem.getOrderItemId());
        verify(orderItemRepository).save(orderItem);


    }

    @Test
    void getAllOrderLists() {
        ArrayList<OrderItem> orderItems = new ArrayList<>();
        when(orderItemRepository.findAll()).thenReturn(orderItems);
        Assertions.assertEquals(orderItemDao.getAllOrderLists(), orderItems);
    }

    @Test
    void getByOIid() {
        OrderItem orderItem = new OrderItem();
        orderItem.setOrderItemId(1);

        when(orderItemRepository.findById(orderItem.getOrderItemId())).thenReturn(Optional.of(orderItem));
        Assertions.assertEquals(orderItemDao.getByOIid(orderItem.getOrderItemId()), orderItem);

        orderItem.setOrderItemId(0);
        when(orderItemRepository.findById(-1)).thenReturn(Optional.empty());
        Assertions.assertEquals(orderItemDao.getByOIid(-1), orderItem);
    }

    @Test
    void getByOid() {
        int oid = 1;
        OrderList orderList = new OrderList();
        orderList.setOrderListId(oid);
        List<OrderItem> orderItems = new ArrayList<>();
        orderList.setOrderItemList(orderItems);
        when(orderListRepository.findById(oid)).thenReturn(Optional.of(orderList));
        Assertions.assertEquals(orderItemDao.getByOid(oid), orderItems);

        OrderItem o = new OrderItem();
        o.setOrderItemId(0);
        orderItems.add(o);
        orderList.setOrderItemList(orderItems);
        Assertions.assertEquals(orderItemDao.getByOid(-1), orderItems);
    }
}