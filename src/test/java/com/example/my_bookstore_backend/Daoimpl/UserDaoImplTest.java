package com.example.my_bookstore_backend.Daoimpl;

import com.example.my_bookstore_backend.entity.User;
import com.example.my_bookstore_backend.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Optional;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserDaoImplTest {
    UserDaoImpl userDao = new UserDaoImpl();
    @Mock
    private UserRepository userRepository;

    static User createUser(String name, String password) {
        User user = new User();
        user.setName(name);
        user.setPassword(password);
        return user;
    }

    static User createUser(String name, String password, int Uid) {
        User user = new User();
        user.setName(name);
        user.setPassword(password);
        user.setUid(Uid);
        return user;
    }

    @BeforeEach
    void beforeEach() {
        userDao.setUserRepository(this.userRepository);
    }

    @Test
    void save() {
        User user = new User();
        // verify if save called userRepository save
        userDao.save(user);
        verify(userRepository).save(user);

    }

    @Test
    void auth() {
        // mock example
        User user = createUser("wjr", "123456");
        when(userRepository.findByNameAndPassword("wjr", "123456")).thenReturn(user);
        Assertions.assertEquals(userDao.auth("wjr", "123456"), user);
        Assertions.assertNull(userDao.auth("tzm", "123456"));
    }

    @Test
    void getAllUsers() {
        ArrayList<User> users = new ArrayList<>();
        when(userRepository.findAll()).thenReturn(users);
        Assertions.assertEquals(userDao.getAllUsers(), users);
    }

    @Test
    void getUserById() {

        User user = createUser("wjr", "123456", 1);
        Optional<User> optionalUser = Optional.of(user);
        when(userRepository.findById(user.getUid())).thenReturn(optionalUser);
        when(userRepository.findById(-1)).thenReturn(Optional.empty());

        Assertions.assertEquals(userDao.getUserById(user.getUid()), user);
        Assertions.assertEquals(userDao.getUserById(-1).getUid(), 0);
    }

    @Test
    void getUserByName() {
        User user = createUser("wjr", "123456");
        when(userRepository.findByName("wjr")).thenReturn(user);
        Assertions.assertEquals(userDao.getUserByName("wjr"), user);
    }

    @Test
    void setstate() {
        User user = createUser("wjr", "123456", 1);

        when(userRepository.findById(user.getUid())).thenReturn(Optional.of(user));
        Assertions.assertEquals(userDao.setstate(user.getUid(), 1), 1);
        Assertions.assertEquals(user.getState(), 1);
        verify(userRepository).save(user);

        when(userRepository.findById(-1)).thenReturn(Optional.empty());
        Assertions.assertEquals(userDao.setstate(-1, 1), 0);
    }
}
