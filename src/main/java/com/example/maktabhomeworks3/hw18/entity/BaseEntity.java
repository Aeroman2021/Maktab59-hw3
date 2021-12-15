package com.example.maktabhomeworks3.hw18.entity;

public interface BaseEntity<ID extends Number>{
    ID getID();
    void setID(ID id);
}
