package com.example.my_bookstore_backend.serviceimpl;

import com.example.my_bookstore_backend.Dao.OrderItemDao;
import com.example.my_bookstore_backend.entity.OrderItem;
import com.example.my_bookstore_backend.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemServiceImpl implements OrderItemService {
    @Autowired
    private OrderItemDao orderItemDao;

    @Override
    public int addNewOrderItem(int bid, int oid, int num) {
        return orderItemDao.addNewOrderItem(bid, oid, num);
    }

    @Override
    public Iterable<OrderItem> getAllOrderLists() {
        return orderItemDao.getAllOrderLists();
    }

    @Override
    public OrderItem getByOIid(int oiid) {
        return orderItemDao.getByOIid(oiid);
    }

    @Override
    public List<OrderItem> getByOid(int oid) {
        return orderItemDao.getByOid(oid);
    }
}
