package com.example.my_bookstore_backend.repository;

import com.example.my_bookstore_backend.entity.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface CartRepository extends CrudRepository<Cart, Integer> {
    @Query("select c from Cart c where c.user=:user")
    List<Cart> getByUid(User user);
}
