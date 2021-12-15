package com.example.maktabhomeworks3.hw18.utility;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class EMFSingleton {
    private static final EntityManager em = Persistence
            .createEntityManagerFactory("BooK_Shop")
            .createEntityManager();
    public static EntityManager getEntityManager(){
        return em;
    }
}
