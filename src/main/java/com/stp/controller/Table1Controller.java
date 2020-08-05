package com.stp.controller;

import com.stp.entity.Table1;
import com.stp.service.Table1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/table1")
public class Table1Controller {
    @Autowired
    private Table1Service table1Service;

    // 查询所有
    @RequestMapping("/findAll")
    public List<Table1> findAll(){
        return table1Service.findAll();
    }
    // 根据id查询
    public Table1 findAllByFields(String fields){
        return table1Service.findByFields(fields);
    }
    // 删除
    public void delete(int id){
        table1Service.delete(id);
    }
    // 修改
    public void update(){

    }
    // 增加
    public void add(){

    }
}
