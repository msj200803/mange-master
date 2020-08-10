package com.stp.service;

import com.alibaba.fastjson.JSONObject;
import com.stp.entity.Task;

import java.io.IOException;

public interface TaskService {
    // 添加任务
    int insertTask(Task task);
    // 通过keys得到建表sql
    String generateSQL(String keys,String name);
    // 得到缩写
    String getAbbreviation(String kyes);
    // 执行建表
    int createTaskTable(String sql);
    // 得到最新的任务
    Task getNewWestTask();
    // 根据ID得到任务
    Task getTaskById(Integer id);
    // 通过ID获取到任务然后将数据填到任务的表里(前端还未完全兼容)
    int insertDataByTaskId(JSONObject jsonObject,Integer id,String fileData) throws IOException;
}
