package com.example.demo.dao;

import com.example.demo.entity.UserLogin;

import java.util.List;

public interface UserLoginDAO {
    List<UserLogin> findAll();
    UserLogin findById(int id);
    UserLogin findLoginByEmail(String email);
    void save(UserLogin userlogin);
    void deleteById(int id);
}
