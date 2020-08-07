package com.stp.service;

import com.stp.entity.User;

import java.util.List;

public interface UserService {
    //根据组ID获取用户
    List<User> getUsersByGroupId(Integer groupId);
    //获得全部用户
    List<User> getUsers();
}
