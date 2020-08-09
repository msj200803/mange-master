package com.stp.service;

import com.stp.entity.tk_tn;

import java.util.List;

public interface Table1Service {
    List<tk_tn> findAll();
    tk_tn findByFields(String fields);
    void delete(int fields);
    void update(tk_tn tb1);
    void add(tk_tn tb1);
}
