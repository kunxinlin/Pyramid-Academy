package com.example.demo.dao;

import com.example.demo.entity.Student;

import java.util.List;

public interface StudentDAO {
    List<Student> findAll();
    Student findById(int id);
    List<Student> findByLastName(String lastName);
    void save(Student student);
    void deleteById(int id);
}
