package com.palmarcell.utility;


import lombok.extern.slf4j.Slf4j;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by gemboly on 2018. 06. 30., 2018
 */
@Slf4j
public class Manager implements AutoCloseable {

    private static EntityManagerFactory entityManagerFactory;
    private static EntityManager entityManager;

    static  {
        entityManagerFactory = Persistence.createEntityManagerFactory("krumpli");
        entityManager = entityManagerFactory.createEntityManager();

    }

    public static EntityManager getInstance() {
        return entityManager;

    }

    @Override
    public void close() throws Exception {
        if (entityManagerFactory != null) {
            entityManager.close();
            entityManagerFactory.close();
        }
    }
}
