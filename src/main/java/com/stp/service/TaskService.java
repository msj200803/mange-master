package com.stp.service;

import com.stp.entity.Task;

public interface TaskService {
    int insertTask(Task task);
    String generateSQL(String keys,String name);
    String getAbbreviation(String kyes);
    int createTaskTable(String sql);
    Task getNewWestTask();
}
