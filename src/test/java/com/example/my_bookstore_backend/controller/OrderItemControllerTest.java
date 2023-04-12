package com.example.my_bookstore_backend.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.my_bookstore_backend.entity.Book;
import com.example.my_bookstore_backend.entity.OrderItem;
import com.example.my_bookstore_backend.entity.OrderList;
import com.example.my_bookstore_backend.entity.User;
import com.example.my_bookstore_backend.service.OrderItemService;
import com.example.my_bookstore_backend.service.OrderListService;
import com.fasterxml.jackson.databind.util.ArrayIterator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class OrderItemControllerTest {

    @Mock
    private OrderItemService orderItemService;

    @Mock
    private OrderListService orderListService;

    private final OrderItemController orderItemController = new OrderItemController();

    @BeforeEach
    void setUp(){
        orderItemController.setOrderItemService(orderItemService);
        orderItemController.setOrderListService(orderListService);
    }

    static Book createBook(int bid){
        Book book = new Book();
        book.setBid(bid);
        return book;
    }

    static OrderList createOrderList(int oid, User user){
        OrderList orderList = new OrderList();
        orderList.setOrderListId(oid);
        orderList.setUser(user);
        return orderList;
    }

    static User createUser(String name, String password, int uid) {
        User user = new User();
        user.setName(name);
        user.setPassword(password);
        user.setUid(uid);
        return user;
    }

    static OrderItem createOrderItem(Book book, OrderList orderList, int num){
        OrderItem orderItem = new OrderItem();
        orderItem.setBook(book);
        orderItem.setOrderList(orderList);
        orderItem.setNum(num);
        return orderItem;
    }


    @Test
    void addNewOrderItem(){
        int bid = 1;
        int oid = 2;
        int num = 10;
        when(orderItemService.addNewOrderItem(1,2,10)).thenReturn(5);
        assertEquals(orderItemController.addNewOrderItem(1,2,10), 5);
    }

    @Test
    void getAllOrderLists(){

        // no loop
        ArrayList<OrderItem> empty_oi_list = new ArrayList<>();
        List<JSONObject> empty_json_list = new ArrayList<>();
        when(orderItemService.getAllOrderLists()).thenReturn(empty_oi_list);
        assertEquals(orderItemController.getAllOrderLists(), empty_json_list);

        // loop once
        Book book1 = createBook(1);
        User user1 = createUser("tzm", "13w323",2);
        OrderList orderList1 = createOrderList(1, user1);
        int num1 = 20;
        OrderItem orderItem1 = createOrderItem(book1, orderList1, num1);

        ArrayList<OrderItem> oi1_list = new ArrayList<>();
        List<JSONObject> json1_list = new ArrayList<>();
        oi1_list.add(orderItem1);
        JSONObject data1 = new JSONObject();
        data1.put("orderListId", orderList1.getOrderListId());
        data1.put("price", orderList1.getPrice());
        data1.put("time", orderList1.getTime());
        data1.put("uid", orderList1.getUser().getUid());
        data1.put("username", orderList1.getUser().getName());
        data1.put("bookname", book1.getName());
        data1.put("bookprice", book1.getPrice());
        json1_list.add(data1);

        when(orderItemService.getAllOrderLists()).thenReturn(oi1_list);
        assertEquals(orderItemController.getAllOrderLists(), json1_list);

    }

    @Test
    void getByOIid(){
        Book book1 = createBook(5);
        User user1 = createUser("tzm", "1342523",2);
        OrderList orderList1 = createOrderList(3, user1);
        int num1 = 25;
        OrderItem orderItem1 = createOrderItem(book1, orderList1, num1);

        when(orderItemService.getByOIid(num1)).thenReturn(orderItem1);
        assertEquals(orderItemController.getByOIid(num1), orderItem1);
    }

    @Test
    void getByOid(){
        Book book1 = createBook(5);
        User user1 = createUser("tzm", "1342523",2);
        OrderList orderList1 = createOrderList(3, user1);
        int num1 = 25;
        OrderItem orderItem1 = createOrderItem(book1, orderList1, num1);
        List<OrderItem> orderItemList = new ArrayList<>();
        orderItemList.add(orderItem1);

        when(orderItemService.getByOid(orderList1.getOrderListId())).thenReturn(orderItemList);
        assertEquals(orderItemController.getByOid(orderList1.getOrderListId()), orderItemList);


    }

    @Test
    void getByUid(){
        // no loop
        List<OrderList> empty_o_list = new ArrayList<>();
        List<JSONObject> empty_json_list = new ArrayList<>();
        when(orderListService.getByUid(10)).thenReturn(empty_o_list);
        assertEquals(orderItemController.getByUid(10), empty_json_list);

        // loop once
        Book book1 = createBook(1);
        User user1 = createUser("tzm", "13w323",2);
        OrderList orderList1 = createOrderList(1, user1);
        List<OrderList> orderListList = new ArrayList<>();
        orderListList.add(orderList1);
        int num1 = 20;
        OrderItem orderItem1 = createOrderItem(book1, orderList1, num1);
        ArrayList<OrderItem> oi1_list = new ArrayList<>();
        List<JSONObject> json1_list = new ArrayList<>();
        oi1_list.add(orderItem1);
        JSONObject data1 = new JSONObject();
        data1.put("orderListId", orderList1.getOrderListId());
        data1.put("orderItemId", orderItem1.getOrderItemId());
        data1.put("bookname", book1.getName());
        data1.put("bookprice", book1.getPrice());
        data1.put("price", orderList1.getPrice());
        data1.put("time", orderList1.getTime());
        data1.put("num", orderItem1.getNum());
        json1_list.add(data1);

        when(orderListService.getByUid(orderList1.getUser().getUid())).thenReturn(orderListList);
        when(orderItemService.getByOid(orderList1.getOrderListId())).thenReturn(oi1_list);
        assertEquals(orderItemController.getByUid(orderList1.getUser().getUid()), json1_list);

    }


}
