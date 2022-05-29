package com.example.my_bookstore_backend.repository;

import com.example.my_bookstore_backend.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface UserRepository extends CrudRepository<User, Integer> {
    @Query("from User u where u.name=:name and u.password=:password")
    User auth(String name, String password);
}