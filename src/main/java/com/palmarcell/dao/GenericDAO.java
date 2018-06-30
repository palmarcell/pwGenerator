package com.palmarcell.dao;

import java.io.Serializable;

/**
 * Created by gemboly on 2018. 06. 30., 2018
 */
public interface GenericDAO<T, ID> extends Serializable {

    /**
     * Mentésre szolgáló függvény.
     *
     * @param entity - A mentendő entitás
     */
    void persist(T entity);

    /**
     * Frissítésre szolgáló függvény.
     *
     * @param entity - A frissítendő entitás
     */
    void update(T entity);

    /**
     * Törlésre szolgáló függvény.
     *
     * @param entity - A törlendő entitás.
     */
    void delete(T entity);

}

