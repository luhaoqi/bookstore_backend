package com.example.my_bookstore_backend.serviceimpl;

import com.example.my_bookstore_backend.Dao.OrderListDao;
import com.example.my_bookstore_backend.entity.OrderList;
import com.example.my_bookstore_backend.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OrderListServiceImplTest {

    private OrderListServiceImpl orderListService;

    @Mock
    private OrderListDao orderListDao;


    @BeforeEach
    void setUp() {
        orderListService = new OrderListServiceImpl();
        orderListService.setOrderListDao(orderListDao);
    }

    @Test
    void addNewOrderList() {
        when(orderListDao.addNewOrderList(0, 0, "0")).thenReturn(0);
        Assertions.assertEquals(0, orderListService.addNewOrderList(0, 0, "0"));
    }

    @Test
    void getAllOrderLists() {
        ArrayList<OrderList> orderLists = new ArrayList<>();
        when(orderListDao.getAllOrderLists()).thenReturn(orderLists);
        Assertions.assertEquals(orderLists, orderListService.getAllOrderLists());
    }

    @Test
    void getByOid() {
        OrderList orderList = new OrderList();
        orderList.setOrderListId(0);
        when(orderListDao.getByOid(orderList.getOrderListId())).thenReturn(orderList);
        Assertions.assertEquals(orderList, orderListService.getByOid(orderList.getOrderListId()));
    }

    @Test
    void getByUid() {
        List<OrderList> orderList = new ArrayList<>();
        User user = new User();
        user.setUid(0);
        when(orderListDao.getByUid(user.getUid())).thenReturn(orderList);
        Assertions.assertEquals(orderList, orderListService.getByUid(user.getUid()));
    }

    @Test
    void purchase() {
        OrderList orderList = new OrderList();
        when(orderListDao.purchase(0, "", "", "")).thenReturn(orderList);
        Assertions.assertEquals(orderList, orderListService.purchase(0, "", "", ""));
    }
}