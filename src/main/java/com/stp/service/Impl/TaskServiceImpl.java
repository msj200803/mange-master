package com.stp.service.Impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.stp.entity.Task;
import com.stp.mapper.TaskMapper;
import com.stp.service.TaskService;
import com.stp.util.ChineseToFirstLetterUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    TaskMapper taskMapper;
    //添加任务到任务中心
    @Override
    public int insertTask(Task task) {
        return taskMapper.insertTask(task);
    }
    //获取建表sql
    @Override
    public String generateSQL(String keys,String name) {
        StringBuilder sql = new StringBuilder("create table if not exists "+name+" (" +" "+
                "id bigint(11) NOT NULL AUTO_INCREMENT,");
        JSONArray objects = JSONObject.parseArray(keys);
        for (int i = 0; i < objects.size(); i++) {
            JSONObject data = objects.getJSONObject(i);
            String key = data.getString("fileds");
            String qus_type = data.getString("qus_type");
            String qus = data.getString("qus");
            if (qus_type.equals("文字")){
                qus_type = "varchar(255)";
            }else if (qus_type.equals("数字")){
                qus_type = "int";
            }else if (qus_type.equals("浮点")){
                qus_type = "double";
            }else if (qus_type.equals("日期")){
                qus_type = "datetime";
            }
            sql.append(key+" "+ qus_type + " "+ "COMMENT" + " \'"+qus+"\', ");
        }
        sql.append("PRIMARY KEY (`id`)");
        sql.append(");");
        return sql.toString();
    }
    //获取tag标签
    @Override
    public String getAbbreviation(String keys) {
        JSONArray objects = JSONObject.parseArray(keys);
        String[] strings = new String[objects.size()];
        for (int i = 0; i < objects.size(); i++) {
            JSONObject data = objects.getJSONObject(i);
            String qus = data.getString("qus");
            strings[i] =  ChineseToFirstLetterUtil.ChineseToFirstLetter(qus).toLowerCase();
        }
        return JSONObject.toJSONString(strings);
    }

    @Override
    public int createTaskTable(String sql) {

        return taskMapper.createTable(sql);
    }

    @Override
    public Task getNewWestTask() {
        return taskMapper.getNewWestTask();
    }

}
