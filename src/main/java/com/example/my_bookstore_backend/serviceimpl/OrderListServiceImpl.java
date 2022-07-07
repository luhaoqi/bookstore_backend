package com.example.my_bookstore_backend.serviceimpl;

import com.example.my_bookstore_backend.DTO.OrderListDTO;
import com.example.my_bookstore_backend.Dao.OrderListDao;
import com.example.my_bookstore_backend.entity.OrderList;
import com.example.my_bookstore_backend.service.OrderListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderListServiceImpl implements OrderListService {
    @Autowired
    private OrderListDao orderListDao;

    @Override
    public int addNewOrderList(int uid, int price, String time) {
        return orderListDao.addNewOrderList(uid, price, time);
    }

    @Override
    public Iterable<OrderList> getAllOrderLists() {
        return orderListDao.getAllOrderLists();
    }

    @Override
    public OrderList getByOid(int oid) {
        return orderListDao.getByOid(oid);
    }

    @Override
    public List<OrderList> getByUid(int uid) {
        return orderListDao.getByUid(uid);
    }

    @Override
    public OrderList purchase(int uid, String tel, String address, String name) {
        return orderListDao.purchase(uid, tel, address, name);
    }
}
