package com.stp.service.Impl;

import com.stp.entity.Table1;
import com.stp.mapper.Table1Mapper;
import com.stp.service.Table1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Table1ServiceImpl implements Table1Service {
    @Autowired
    private Table1Mapper table1Mapper;

    @Override
    public List<Table1> findAll() {
        return table1Mapper.findAll();
    }

    @Override
    public Table1 findByFields(String fields) {
        return table1Mapper.findByFields(fields);
    }

    @Override
    public void delete(int fields) {
        table1Mapper.delete(fields);
    }

    @Override
    public void update(Table1 tb1) {
        table1Mapper.update(tb1);
    }

    @Override
    public void add(Table1 tb1) {
        table1Mapper.add(tb1);
    }
}
