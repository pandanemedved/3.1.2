package com.springboots.springboot.dao;

import com.springboots.springboot.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void insertUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public void deleteUser(Long id) {
        User user = findUserById(id);
        if (user != null) {
            entityManager.remove(user);
        } else {
            throw new EntityNotFoundException(" not found");
        }
    }

    @Override
    public User findUserById(Long id) {
        Optional<User> user = Optional.ofNullable(entityManager.find(User.class, id));
        return user.orElse(null);
    }

    @Override
    public List<User> findAllUser() {
        return entityManager.createQuery("from User", User.class).getResultList();
    }
}
