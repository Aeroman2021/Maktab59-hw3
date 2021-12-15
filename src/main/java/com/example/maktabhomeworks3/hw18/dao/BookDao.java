package com.example.maktabhomeworks3.hw18.dao;

import com.example.maktabhomeworks3.hw18.dao.core.AbstractJPADao;
import com.example.maktabhomeworks3.hw18.entity.Book;

public  class BookDao extends AbstractJPADao<Book,Integer> {

    @Override
    public Class<Book> getEntityClass() {
        return Book.class;
    }
}
