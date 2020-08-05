package com.stp.service;

import com.stp.entity.Table1;

import java.util.List;

public interface Table1Service {
    List<Table1> findAll();
    Table1 findByFields(String fields);
    void delete(int fields);
    void update(Table1 tb1);
    void add(Table1 tb1);
}
