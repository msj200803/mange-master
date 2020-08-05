package com.stp.service;

import com.stp.entity.Table2;

import java.util.List;

public interface Table2service {
    List<Table2> findAll();
    Table2 findById(int id);
    void delete(int id);
    void update(Table2 tb2);
    void add(Table2 tb2);
}
