package com.example.maktabhomeworks3.hw18.manager;

import com.example.maktabhomeworks3.hw18.dao.BookDao;
import com.example.maktabhomeworks3.hw18.entity.Book;

public class BooKManager extends AbstractCrudService<Book,Integer> {

    public BooKManager() {
        setAbstractJPADao(new BookDao());
    }

    @Override
    public BookDao getAbstractJPADao() {
        return (BookDao) super.getAbstractJPADao();
    }
}
