package com.stp.mapper;

import com.stp.entity.Table2;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface Table2Mapper extends tk.mybatis.mapper.common.Mapper<Table2> {
    // 1.查询所有
    List<Table2> findAll();

    // 2.根据id查询
    Table2 findById(int id);

    // 3.删除
    void delete(int id);

    // 4.修改
    void update(Table2 tb2);

    // 5.增加
    void add(Table2 tb2);
}
