package com.example.maktabhomeworks3.hw18;

import com.example.maktabhomeworks3.hw18.entity.Book;
import com.example.maktabhomeworks3.hw18.manager.BooKManager;

public class Main {
    public static void main(String[] args) {
        Book book = new Book("Sound of Wild","Jack London",50000d,"London");
        BooKManager booKManager = new BooKManager();
        booKManager.saveOrUpdate(book);

    }
}
