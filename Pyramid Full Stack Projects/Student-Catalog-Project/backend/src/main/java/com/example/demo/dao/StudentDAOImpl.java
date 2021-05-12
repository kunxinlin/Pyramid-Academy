package com.example.demo.dao;

import com.example.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO{
    private EntityManager entityManager;

    @Autowired
    public StudentDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public List<Student> findAll() {
        Session currentSession = entityManager.unwrap(Session.class);
        return currentSession.createQuery("FROM Student ORDER BY last_name ASC, first_name ASC").getResultList();
    }

    @Override
    @Transactional
    public Student findById(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Student student = currentSession.get(Student.class, id);
        return student;
    }

    @Override
    @Transactional
    public List<Student> findByLastName(String lastName) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<Student> theQuery = currentSession.createQuery("FROM Employee WHERE last_name=:lastName");
        theQuery.setParameter("lastName", lastName);
        List<Student> students = theQuery.getResultList();
        return students;
    }

    @Override
    @Transactional
    public void save(Student student) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(student);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.createQuery("DELETE from Student WHERE id=:StudentId").setParameter("StudentId", id).executeUpdate();
    }
}