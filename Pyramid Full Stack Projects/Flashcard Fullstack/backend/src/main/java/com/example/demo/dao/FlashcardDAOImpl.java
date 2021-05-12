package com.example.demo.dao;

import com.example.demo.entity.Flashcard;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class FlashcardDAOImpl implements FlashcardDAO{
    private EntityManager entityManager;

    @Autowired
    public FlashcardDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public List<Flashcard> findAll() {
        Session currentSession = entityManager.unwrap(Session.class);
        return currentSession.createQuery("FROM Flashcard").getResultList();
    }

    @Override
    @Transactional
    public Flashcard findById(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Flashcard fc = currentSession.get(Flashcard.class, id);
        return fc;
    }

    @Override
    @Transactional
    public Flashcard retrieveRandom() {
        List<Flashcard> cards = findAll();
        int i = (int)(Math.random() * cards.size());
        return cards.get(i);
    }

    @Override
    @Transactional
    public void save(Flashcard flashcard) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(flashcard);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.createQuery("DELETE from Flashcard WHERE id=:FlashcardId").setParameter("FlashcardId", id).executeUpdate();
    }
}
