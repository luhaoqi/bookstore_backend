package com.example.my_bookstore_backend.serviceimpl;

import com.example.my_bookstore_backend.Dao.CartItemDao;
import com.example.my_bookstore_backend.entity.CartItem;
import com.example.my_bookstore_backend.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartItemServiceImpl implements CartItemService {
    private CartItemDao cartItemDao;

    @Autowired
    public void setCartItemDao(CartItemDao cartItemDao) {
        this.cartItemDao = cartItemDao;
    }

    @Override
    public CartItem addNewCartItem(int uid, int bid) {
        return cartItemDao.addNewCartItem(uid, bid);
    }

    @Override
    public CartItem deleteCartItem(int uid, int bid) {
        return cartItemDao.deleteCartItem(uid, bid);
    }

    @Override
    public Iterable<CartItem> getAll() {
        return cartItemDao.getAll();
    }

    @Override
    public CartItem getByOIid(int ciid) {
        return cartItemDao.getByOIid(ciid);
    }

    @Override
    public List<CartItem> getAllCartItemsByUid(int uid) {
        return cartItemDao.getAllCartItemsByUid(uid);
    }

}
