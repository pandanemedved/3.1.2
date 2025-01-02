package com.springboots.springboot.service;

import com.springboots.springboot.dao.UserDao;
import com.springboots.springboot.entity.User;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        userDao.insertUser(user);
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        User updateUser = findUserById(user.getId());
        updateUser.setName(user.getName());
        updateUser.setEmail(user.getEmail());
        userDao.updateUser(updateUser);
    }

    @Override
    @Transactional
    public void deleteUser(Long id) {
        userDao.deleteUser(id);
    }

    @Override
    @Transactional
    public User findUserById(Long id) {
        if (userDao.findUserById(id) != null) {
            return userDao.findUserById(id);
        } else {
            throw new EntityNotFoundException("Пользователь с таким " + id + " не найден");
        }
    }

    @Override
    @Transactional
    public List<User> findAllUsers() {
        return userDao.findAllUser();
    }
}
