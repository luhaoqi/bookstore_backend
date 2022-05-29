package com.example.my_bookstore_backend.Daoimpl;

import com.example.my_bookstore_backend.Dao.OrderItemDao;
import com.example.my_bookstore_backend.entity.Book;
import com.example.my_bookstore_backend.entity.OrderItem;
import com.example.my_bookstore_backend.entity.OrderList;
import com.example.my_bookstore_backend.repository.BookRepository;
import com.example.my_bookstore_backend.repository.OrderItemRepository;
import com.example.my_bookstore_backend.repository.OrderListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class OrderItemDaoImpl implements OrderItemDao {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private OrderItemRepository orderItemRepository;
    @Autowired
    private OrderListRepository orderListRepository;


    @Override
    public int addNewOrderItem(int bid, int oid, int num) {
        OrderItem orderItem = new OrderItem();
        Optional<Book> book = bookRepository.findById(bid);
//        System.out.println(book.isEmpty());
        if (book.isEmpty()) return 0;
        orderItem.setBook(book.get());
        Optional<OrderList> orderList = orderListRepository.findById(oid);
//        System.out.println(orderList.isEmpty());
        if (orderList.isEmpty()) return 0;
        orderItem.setOrderList(orderList.get());
        orderItem.setNum(num);
//        System.out.println(orderItem);
        orderItemRepository.save(orderItem);
        return orderItem.getOrderItemId();
    }

    @Override
    public Iterable<OrderItem> getAllOrderLists() {
        return orderItemRepository.findAll();
    }

    @Override
    public OrderItem getByOIid(int oiid) {
        Optional<OrderItem> x = orderItemRepository.findById(oiid);
        if (x.isPresent()) return x.get();
        OrderItem o = new OrderItem();
        o.setOrderItemId(0);
        return o;
    }

    @Override
    public List<OrderItem> getByOid(int oid) {
        Optional<OrderList> orderList = orderListRepository.findById(oid);
        if (orderList.isPresent()) return orderItemRepository.getAllByOrderList(orderList.get());
        OrderItem o = new OrderItem();
        o.setOrderItemId(0);
        List<OrderItem> l = new ArrayList<>();
        l.add(o);
        return l;
    }
}
