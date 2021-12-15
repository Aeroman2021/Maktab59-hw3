package com.example.maktabhomeworks3.hw18.dao.core;

import com.example.maktabhomeworks3.hw18.entity.BaseEntity;
import com.example.maktabhomeworks3.hw18.utility.EMFSingleton;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public abstract class AbstractJPADao <T extends BaseEntity<ID>,ID extends Number> {
    EntityManager em = EMFSingleton.getEntityManager();

    public void save(T t) {
        em.getTransaction().begin();
        em.persist(t);
        em.getTransaction().commit();
    }

     public abstract Class<T> getEntityClass();

    public void update(T newEntity) {
        em.getTransaction().begin();
        em.merge(newEntity);
        em.getTransaction().commit();
    }

    public void delete(ID id) {
        em.getTransaction().begin();
        T t = em.find(getEntityClass(), id);
        em.remove(t);
        em.getTransaction().commit();
    }

    public T loadById(ID id) {
        return em.find(getEntityClass(), id);
    }

    public List<T> loadAll() {
        TypedQuery<T> query = em.createQuery("SELECT t FROM " +
                getEntityClass().getSimpleName() + " t", getEntityClass());
        return query.getResultList();
    }


}
