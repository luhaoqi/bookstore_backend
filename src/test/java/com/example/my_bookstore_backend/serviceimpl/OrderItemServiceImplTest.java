package com.example.my_bookstore_backend.serviceimpl;

import com.example.my_bookstore_backend.Dao.OrderItemDao;
import com.example.my_bookstore_backend.entity.OrderItem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OrderItemServiceImplTest {

    OrderItemServiceImpl orderItemService;

    @Mock
    private OrderItemDao orderItemDao;

    @BeforeEach
    void setUp() {
        orderItemService = new OrderItemServiceImpl();
        orderItemService.setOrderItemDao(orderItemDao);
    }


    @Test
    void addNewOrderItem() {
        when(orderItemDao.addNewOrderItem(0, 0, 0)).thenReturn(0);
        Assertions.assertEquals(0, orderItemService.addNewOrderItem(0, 0, 0));
    }

    @Test
    void getAllOrderLists() {
        ArrayList<OrderItem> orderItems = new ArrayList<>();
        when(orderItemDao.getAllOrderLists()).thenReturn(orderItems);
        Assertions.assertEquals(orderItems, orderItemService.getAllOrderLists());
    }

    @Test
    void getByOIid() {
        OrderItem orderItem = new OrderItem();
        orderItem.setOrderItemId(0);
        when(orderItemDao.getByOIid(orderItem.getOrderItemId())).thenReturn(orderItem);
        Assertions.assertEquals(orderItem, orderItemService.getByOIid(orderItem.getOrderItemId()));
    }

    @Test
    void getByOid() {
        ArrayList<OrderItem> orderItems = new ArrayList<>();
        when(orderItemDao.getByOid(0)).thenReturn(orderItems);
        Assertions.assertEquals(orderItems, orderItemService.getByOid(0));

    }
}