package com.stp.controller;

import com.stp.entity.Table2;
import com.stp.service.Table2service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/table2")
public class Table2Controller {
    @Autowired
    private Table2service table2service;

    // 查询所有
    @RequestMapping("/findAll")
    public List<Table2> findAll(){
        return table2service.findAll();
    }
    // 根据id查询
    public Table2 findAllById(int id){
        return table2service.findById(id);
    }
    // 删除
    public void delete(int id){
        table2service.delete(id);
    }
    // 修改
    public void update(int id,String EA,String EB,String PP,String PN,String R1,String R2,String R3,String operator,String remarks,String createTime){

    }
    // 增加
    public void add(int id,String EA,String EB,String PP,String PN,String R1,String R2,String R3,String operator,String remarks,String createTime){

    }
}
