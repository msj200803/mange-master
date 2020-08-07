package com.stp.mapper;

import com.stp.entity.Group;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;
@Mapper
@Component
public interface GroupMapper {
    // 获取全部的组
    @Select("select * from  db_label.group")
    List<Group> getGroupList();

    @Select("select * from db_label.group a where a.id=#{groupId}")
    Group getGroupByGroupId(Integer groupId);
}
