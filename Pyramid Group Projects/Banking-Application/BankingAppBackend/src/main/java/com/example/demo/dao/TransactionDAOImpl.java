package com.example.demo.dao;

import com.example.demo.entity.Transaction;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class TransactionDAOImpl implements TransactionDAO{
    private EntityManager entityManager;

    @Autowired
    public TransactionDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public Transaction findTransactionById(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        return currentSession.get(Transaction.class, id);
    }

    @Override
    @Transactional
    public List<Transaction> findAllTransactionsByUserID(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        return currentSession.createQuery("FROM Transaction WHERE userID=:userid").setParameter("userid", id).getResultList();
    }

    @Override
    @Transactional
    public void save(Transaction transaction) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(transaction);
    }

    @Override
    @Transactional
    public void deleteByID(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.createQuery("DELETE from Transaction WHERE id=:Tid").setParameter("Tid", id).executeUpdate();
    }
}
