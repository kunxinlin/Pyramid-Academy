package com.example.demo.dao;

import com.example.demo.entity.Part;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class PartDAO implements PartDAOInterface {

    private EntityManager entityManager;

    @Autowired
    public PartDAO(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public List<Part> findAll() {
        Session currentSession = entityManager.unwrap(Session.class);
        //Query<Part> query = currentSession.createQuery("from Part");
        //List<Part> parts = query.getResultList();

        List<Part> parts = currentSession.createQuery("FROM Part").getResultList();
        return parts;
    }

    @Override
    @Transactional
    public Part findById(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Part part = currentSession.get(Part.class, id);
        return part;
    }

    @Override
    @Transactional
    public void save(Part part) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(part);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<Part> theQuery = currentSession.createQuery("delete FROM Part WHERE id=:partId");
        theQuery.setParameter("partId", id);
        theQuery.executeUpdate();
    }
}
