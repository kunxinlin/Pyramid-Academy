package com.example.demo.dao;

import com.example.demo.entity.User;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO{
    private EntityManager entityManager;

    @Autowired
    public UserDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public List<User> findAll() {
        Session currentSession = entityManager.unwrap(Session.class);
        return currentSession.createQuery("FROM User ORDER BY last_name ASC, first_name ASC").getResultList();
    }

    @Override
    @Transactional
    public User findById(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        User user = currentSession.get(User.class, id);
        return user;
    }

    @Override
    @Transactional
    public List<User> findByLastName(String lastName) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<User> theQuery = currentSession.createQuery("FROM Employee WHERE last_name=:lastName");
        theQuery.setParameter("lastName", lastName);
        List<User> users = theQuery.getResultList();
        return users;
    }

    @Override
    @Transactional
    public void save(User user) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(user);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.createQuery("DELETE from User WHERE id=:UserId").setParameter("UserId", id).executeUpdate();
    }
}
