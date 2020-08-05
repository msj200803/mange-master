package com.stp.mapper;

import com.stp.entity.Table1;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface Table1Mapper {
    // 1.查询所有
    List<Table1> findAll();

    // 2.根据fields查询
    Table1 findByFields(String fields);

    // 3.删除
    void delete(int fields);

    // 4.修改
    void update(Table1 tb1);

    // 5.增加
    void add(Table1 tb1);
}
