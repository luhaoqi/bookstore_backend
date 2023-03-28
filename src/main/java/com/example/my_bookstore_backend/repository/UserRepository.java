package com.example.my_bookstore_backend.repository;

import com.example.my_bookstore_backend.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete
@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    User findByNameAndPassword(String name, String password);

    User findByName(String username);


}