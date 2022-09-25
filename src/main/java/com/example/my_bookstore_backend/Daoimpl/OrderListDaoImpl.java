package com.example.my_bookstore_backend.Daoimpl;

import com.example.my_bookstore_backend.Dao.OrderListDao;
import com.example.my_bookstore_backend.entity.OrderList;
import com.example.my_bookstore_backend.entity.User;
import com.example.my_bookstore_backend.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public class OrderListDaoImpl implements OrderListDao {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OrderListRepository orderListRepository;

    @Autowired
    CartItemRepository cartItemRepository;

    @Autowired
    OrderItemRepository orderItemRepository;

    @Autowired
    BookRepository bookRepository;


    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void save(OrderList o) {
//        int a = 10 / 0;
        orderListRepository.save(o);
    }

    @Override
    public int addNewOrderList(int uid, int price, String time) {
        OrderList orderList = new OrderList();
        Optional<User> user = userRepository.findById(uid);
        if (user.isPresent()) {
            orderList.setUser(user.get());
            orderList.setPrice(price);
            orderList.setTime(time);
            orderListRepository.save(orderList);
            return orderList.getOrderListId();
        }
        return 0;
    }

    @Override
    public Iterable<OrderList> getAllOrderLists() {
        return orderListRepository.findAll();
    }

    @Override
    public OrderList getByOid(int oid) {
        Optional<OrderList> x = orderListRepository.findById(oid);
        if (x.isPresent()) return x.get();
        OrderList o = new OrderList();
        o.setOrderListId(0);
        return o;
    }

    @Override
    public List<OrderList> getByUid(int uid) {
        Optional<User> user = userRepository.findById(uid);
        if (user.isEmpty()) return null;
        return orderListRepository.getAllByUid(user.get());
    }

}
