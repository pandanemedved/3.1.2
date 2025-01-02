package com.springboots.springboot.service;

import com.springboots.springboot.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    void saveUser(User user);

    void updateUser(User user);

    void deleteUser(Long id);

    User findUserById(Long id);

    List<User> findAllUsers();
}
