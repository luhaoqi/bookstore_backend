package com.example.my_bookstore_backend.Daoimpl;

import com.example.my_bookstore_backend.Dao.UserDao;
import com.example.my_bookstore_backend.entity.User;
import com.example.my_bookstore_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void save(User u) {
        userRepository.save(u);
    }

    @Override
    public User auth(String name, String password) {
        return userRepository.findByNameAndPassword(name, password);
    }

    @Override
    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(int uid) {
        Optional<User> x = userRepository.findById(uid);
        if (x.isPresent()) return x.get();
        User u = new User();
        u.setUid(0);
        return u;
    }

    @Override
    public User getUserByName(String username) {
        User x = userRepository.findByName(username);
        return x;
    }

    @Override
    public int setstate(int uid, int s) {
        Optional<User> x = userRepository.findById(uid);
        if (x.isPresent()) {
            User u = x.get();
            u.setState(s);
            userRepository.save(u);
            return 1;
        }
        return 0;
    }
}
