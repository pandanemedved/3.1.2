package com.springboots.springboot.dao;

import com.springboots.springboot.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserDao {

    void insertUser(User user);

    void updateUser(User user);

    void deleteUser(Long id);

    User findUserById(Long id);

    List<User> findAllUser();
}
