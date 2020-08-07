package com.stp.mapper;

import com.stp.entity.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Component;

import java.util.List;
@Mapper
@Component
public interface UserMapper {
    //根据组ID获取用户
    @Select("select * from db_label.tb_user where is_group_id = #{groupId}")
//    @Results({
//            @Result(id = true,column = "id",property = "id"),
//            @Result(column = "user_id",property = "userId"),
//            @Result(column = "user_account",property = "userAccount"),
//            @Result(column = "user_password",property = "userPassword"),
//            @Result(column = "user_name",property = "userName"),
//            @Result(column = "user_authority",property = "userAuthority"),
//           // @Result(column = "is_group_id",one = @One(select = "com.stp.mapper.GroupMapper.getGroupByGroupId",fetchType = FetchType.EAGER)),
//    })
    List<User> getUsersByGroupId(Integer groupId);
    //获取全部的用户
    @Select("select * from db_label.tb_user")
    List<User> getUsers();

}
