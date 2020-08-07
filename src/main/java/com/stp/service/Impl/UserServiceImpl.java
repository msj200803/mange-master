package com.stp.service.Impl;

import com.stp.entity.User;
import com.stp.mapper.UserMapper;
import com.stp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    //根据组ID查组内的全部人
    @Override
    public List<User> getUsersByGroupId(Integer groupId) {
        return userMapper.getUsersByGroupId(groupId);
    }
    //获得全部用户
    @Override
    public List<User> getUsers() {
        return userMapper.getUsers();
    }

}
