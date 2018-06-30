package com.palmarcell.dao.impl;

import com.palmarcell.dao.PassDAO;
import com.palmarcell.model.PassEntity;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by gemboly on 2018. 06. 30., 2018
 */
public class PassDAOImpl implements PassDAO {

    private EntityManager entityManager;

    public PassDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void persist(PassEntity entity) {

        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
    }

    @Override
    public void update(PassEntity entity) {

        entityManager.getTransaction().begin();
        entityManager.merge(entity);
        entityManager.getTransaction().commit();

    }

    @Override
    public void delete(PassEntity entity) {

        entityManager.getTransaction().begin();
        entityManager.remove(entity);
        entityManager.getTransaction().commit();
    }

    public List<PassEntity> getPasses(){

        TypedQuery<PassEntity> query = entityManager.createQuery("SELECT e FROM PassEntity e",PassEntity.class);

        return query.getResultList();

    }

}
