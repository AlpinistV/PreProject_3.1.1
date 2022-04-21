package com.example.PreProject_311.start.dao;

import com.example.PreProject_311.start.model.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();

    User getUser(long id);

    void saveUser(User user);

    void updateUser(long id, User updateUser);

    void deleteUser(long id);
}
