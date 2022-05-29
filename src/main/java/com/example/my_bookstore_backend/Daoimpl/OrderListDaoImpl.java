package com.example.my_bookstore_backend.Daoimpl;

import com.example.my_bookstore_backend.Dao.OrderListDao;
import com.example.my_bookstore_backend.entity.Cart;
import com.example.my_bookstore_backend.entity.OrderList;
import com.example.my_bookstore_backend.entity.User;
import com.example.my_bookstore_backend.repository.CartItemRepository;
import com.example.my_bookstore_backend.repository.OrderListRepository;
import com.example.my_bookstore_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.text.SimpleDateFormat;
import java.util.Date;
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

    @Override
    public String purchase(int uid) {
        Optional<User> user = userRepository.findById(uid);
        if (user.isEmpty()) return "{s:false}";
        Cart cart = user.get().getCart();

        OrderList orderList = new OrderList();
        orderList.setUser(user.get());
        Date currentTime = new Date();//当前日期
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//定义新的日期格式
        String dateString = formatter.format(currentTime);
        orderList.setTime(dateString);
        orderList.setPrice(cart.getPrice());
        orderListRepository.save(orderList);

        //TODO:存储物品

        cart.setPrice(0);
        cartItemRepository.clear(cart);
        return "{s:true}";
    }
}
