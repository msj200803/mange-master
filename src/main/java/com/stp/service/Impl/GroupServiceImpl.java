package com.stp.service.Impl;

import com.stp.entity.Group;
import com.stp.mapper.GroupMapper;
import com.stp.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupServiceImpl implements GroupService {

    @Autowired
    GroupMapper groupMapper;
    // 获取全部组
    @Override
    public List<Group> getGroups() {
        return groupMapper.getGroupList();
    }
}
