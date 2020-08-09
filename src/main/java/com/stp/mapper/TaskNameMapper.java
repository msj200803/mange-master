package com.stp.mapper;

import com.stp.entity.tk_tn;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface Table1Mapper extends tk.mybatis.mapper.common.Mapper<tk_tn> {
    // 2.根据fields查询
    tk_tn findByFields(String fields);

    // 3.删除
    void delete(int fields);

    // 4.修改
    void update(tk_tn tb1);

    // 5.增加
    void add(tk_tn tb1);
}
