package com.example.my_bookstore_backend.controller;

import com.example.my_bookstore_backend.entity.Book;
import com.example.my_bookstore_backend.entity.OrderItem;
import com.example.my_bookstore_backend.entity.OrderList;
import com.example.my_bookstore_backend.entity.User;
import com.example.my_bookstore_backend.service.OrderListService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OrderListControllerTest {
    private final OrderListController orderListController = new OrderListController();
    private final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//定义新的日期格式
    @Mock
    private OrderListService orderListService;

    @BeforeEach
    void setUp() {
        orderListController.setOrderListService(orderListService);
    }

    @Test
    void addNewOrderList() {
        int uid = 1;
        int price = 100;
        String time = formatter.format(new Date());
        int orderListId = 3;
        when(orderListService.addNewOrderList(uid, price, time)).thenReturn(orderListId);
        when(orderListService.addNewOrderList(-1, price, time)).thenReturn(0);

        assertEquals(orderListController.addNewOrderList(uid, price, time), orderListId);
        assertEquals(orderListController.addNewOrderList(-1, price, time), 0);
    }

    OrderList createOrderList(int oid, int uid) {
        OrderList orderList = new OrderList();
        orderList.setOrderListId(oid);
        List<OrderItem> orderItems = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            OrderItem orderItem = new OrderItem();
            orderItem.setOrderItemId(i);
            orderItem.setNum(i);
            orderItem.setPrice(i);
            orderItem.setOrderList(orderList);
            Book book = new Book();
            book.setBid(i);
            orderItem.setBook(book);
            orderItems.add(orderItem);
        }
        User user = new User();
        user.setUid(uid);
        user.setName("wjr");
        orderList.setUser(user);

        orderList.setOrderItemList(orderItems);
        return orderList;
    }

    @Test
    void getAllOrderLists() {
        List<OrderList> list = new ArrayList<>();
        OrderList orderList = createOrderList(1, 1);
        orderList.getUser().setOrderLists(list);
        list.add(orderList);
        when(orderListService.getAllOrderLists()).thenReturn(list);
        assertEquals(orderListController.getAllOrderLists(), list.stream().map(OrderList::ToOrderListDTO).collect(Collectors.toList()));
    }

    @Test
    void getByOid() {
        int oid = 1;
        OrderList orderList = createOrderList(oid, 1);
        when(orderListService.getByOid(oid)).thenReturn(orderList);
        assertEquals(orderListController.getByOid(oid), orderList);
    }

    @Test
    void getByUid() {
        int oid = 1, uid = 1;
        List<OrderList> list = new ArrayList<>();
        OrderList orderList = createOrderList(oid, uid);
        orderList.getUser().setOrderLists(list);
        list.add(orderList);
        when(orderListService.getByUid(uid)).thenReturn(list);
        assertEquals(orderListController.getByUid(uid), list.stream().map(OrderList::ToOrderListDTO).collect(Collectors.toList()));
    }

    @Test
    void purchase() {
        int oid = 1, uid = 1;
        String tel = "13712341234";
        String address = "China";
        String name = "wjr";

        OrderList orderList = createOrderList(oid, uid);
        when(orderListService.purchase(uid, tel, address, name)).thenReturn(orderList);
        assertEquals(orderListController.purchase(uid, tel, address, name), orderList);

        when(orderListService.purchase(-1, tel, address, name)).thenReturn(null);
        OrderList o = new OrderList();
        o.setOrderListId(0);
        assertEquals(orderListController.purchase(-1, tel, address, name), o);
    }
}