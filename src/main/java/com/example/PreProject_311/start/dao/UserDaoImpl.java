package com.example.PreProject_311.start.dao;

import org.springframework.stereotype.Repository;
import com.example.PreProject_311.start.model.User;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
        TypedQuery<User> query = entityManager.createQuery("SELECT u FROM User u", User.class);
        return query.getResultList();
    }

    @Override
    public User getUser(long id) {
        TypedQuery<User> query = entityManager.createQuery("SELECT u FROM User u WHERE u.id = :id", User.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public void saveUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void updateUser(long id, User updateUser) {
        User upUser = entityManager.find(User.class, updateUser.getId());
        upUser.setName(updateUser.getName());
        upUser.setLastname(updateUser.getLastname());
        upUser.setAge(updateUser.getAge());
    }

    @Override
    public void deleteUser(long id) {
        User oldUser = entityManager.find(User.class, id);
        entityManager.remove(oldUser);
    }
}
