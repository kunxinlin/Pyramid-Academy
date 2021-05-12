package com.example.demo.dao;

import com.example.demo.entity.UserLogin;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class UserLoginDAOImpl implements UserLoginDAO {
    private EntityManager entityManager;

    @Autowired
    public UserLoginDAOImpl(EntityManager entityManager){this.entityManager = entityManager;}

    @Override
    @Transactional
    public List<UserLogin> findAll(){
        Session currentSession = entityManager.unwrap(Session.class);
        return currentSession.createQuery("FROM UserLogin").getResultList();
    }

    @Override
    @Transactional
    public UserLogin findById(int id){
        Session currentSession = entityManager.unwrap(Session.class);
        UserLogin user = currentSession.get(UserLogin.class, id);
        return user;
    }

    @Override
    @Transactional
    public UserLogin findLoginByEmail(String email){
        Session currentSession = entityManager.unwrap(Session.class);
        List<UserLogin> logins = currentSession.createQuery("FROM UserLogin WHERE email=:employeeEmail").setParameter("employeeEmail", email).getResultList();
        return logins.get(0);
    }

    @Override
    @Transactional
    public void save(UserLogin userlogin) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(userlogin);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.createQuery("DELETE FROM UserLogin WHERE id=:userId").setParameter("userId", id).executeUpdate();
    }
}
