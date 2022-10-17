package com.example.my_bookstore_backend.serviceimpl;

import com.example.my_bookstore_backend.Dao.*;
import com.example.my_bookstore_backend.entity.*;
import com.example.my_bookstore_backend.service.OrderListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class OrderListServiceImpl implements OrderListService {
    @Autowired
    private OrderListDao orderListDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private OrderItemDao orderItemDao;
    @Autowired
    private BookDao bookDao;
    @Autowired
    private CartItemDao cartItemDao;

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
    @Transactional(propagation = Propagation.REQUIRED)
    public OrderList purchase(int uid, String tel, String address, String name) {
        System.out.println("In Service: " + uid + "," + tel + "," + address + "," + name);
        User user = userDao.getUserById(uid);
        if (user.getUid() == 0) return null;

        List<CartItem> cartItemList = user.getCartItemList();

        OrderList orderList = new OrderList();
        orderList.setUser(user);
        Date currentTime = new Date();//当前日期
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//定义新的日期格式
        String dateString = formatter.format(currentTime);
        orderList.setTime(dateString);

        orderList.setTel(tel);
        orderList.setAddress(address);
        orderList.setName(name);

//        int a = 10 / 0;

        int totPrice = 0;
        for (CartItem x : cartItemList) {
            totPrice += x.getNum() * x.getBook().getPrice();
            if (x.getBook().getStock() < x.getNum()) {
                //库存不够
                return null;
            }
        }
        orderList.setPrice(totPrice);
        orderListDao.save(orderList);

//        int a = 10 / 0;

        for (CartItem x : cartItemList) {
            //存储物品到orderItem
            OrderItem o = new OrderItem();
            o.setNum(x.getNum());
            o.setPrice(x.getBook().getPrice());
            o.setBook(x.getBook());
            o.setOrderList(orderList);
            orderItemDao.save(o);

            //修改书籍对应的库存与销量
            Book book = x.getBook();
            book.setSales(book.getSales() + x.getNum());
            book.setStock(book.getStock() - x.getNum());
            bookDao.save(book);
        }

        cartItemDao.clear(user);
        return orderList;
    }
}
