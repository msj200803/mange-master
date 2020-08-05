package com.stp.service.Impl;

import com.stp.entity.Table2;
import com.stp.mapper.Table2Mapper;
import com.stp.service.Table2service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Table2ServiceImpl implements Table2service {
    @Autowired
    private Table2Mapper table2Mapper;

    @Override
    public List<Table2> findAll() {
        return table2Mapper.findAll();
    }

    @Override
    public Table2 findById(int id) {
        return table2Mapper.findById(id);
    }

    @Override
    public void delete(int id) {
        table2Mapper.delete(id);
    }

    @Override
    public void update(Table2 tb2) {
        table2Mapper.update(tb2);
    }

    @Override
    public void add(Table2 tb2) {
        table2Mapper.add(tb2);
    }
}
