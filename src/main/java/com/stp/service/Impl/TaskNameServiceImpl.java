package com.stp.service.Impl;

import com.stp.entity.tk_tn;
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
    public List<tk_tn> findAll() {
        return table1Mapper.selectAll();
    }

    @Override
    public tk_tn findByFields(String fields) {
        return table1Mapper.findByFields(fields);
    }

    @Override
    public void delete(int fields) {
        table1Mapper.delete(fields);
    }

    @Override
    public void update(tk_tn tb1) {
        table1Mapper.update(tb1);
    }

    @Override
    public void add(tk_tn tb1) {
        table1Mapper.add(tb1);
    }
}
