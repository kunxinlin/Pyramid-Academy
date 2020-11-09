package com.example.demo.dao;

import com.example.demo.entity.User;

import java.util.List;

public interface UserDAO {
    List<User> findAll();
    User findById(int id);
    List<User> findByLastName(String lastName);
    void save(User user);
    void deleteById(int id);
}
