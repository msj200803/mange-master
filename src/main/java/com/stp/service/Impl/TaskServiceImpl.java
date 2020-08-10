package com.stp.service.Impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.stp.entity.Task;
import com.stp.mapper.TaskMapper;
import com.stp.service.TaskService;
import com.stp.util.ChineseToFirstLetterUtil;
import com.stp.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

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

    @Override
    public Task getTaskById(Integer id) {
        return taskMapper.getTaskById(id);
    }

    @Override
    public int insertDataByTaskId(JSONObject jsonObject, Integer id, String fileData) throws IOException {
        // 通过ID获取到任务
        Task taskById = taskMapper.getTaskById(id);
        // 获取valueList
        JSONArray keyData = jsonObject.getJSONArray("keyData");
        // 保存文件 (在事件前面加上userid)
        FileUtil.saveFile(new ByteArrayInputStream(fileData.getBytes()),"D://testc/"+taskById.getTaskName()+"/"+ LocalDateTime.now().toString().replaceAll(":","")+".txt");
        // 获得key和问题的list
        JSONArray keys = JSON.parseArray(taskById.getTaskKeys());
        // 拼接sql
        StringBuilder sql = new StringBuilder("insert into "+taskById.getTaskName()+" values(0,");
        // 根据key问题的list里的key得到对应的value然后拼接上
        for (int i = 0; i < keys.size(); i++) {
            if (keys.getJSONObject(i).getString("qus_type").equals("日期")||keys.getJSONObject(i).getString("qus_type").equals("文字")){
                System.out.println("\'"+keyData.getJSONObject(i).getString(keys.getJSONObject(i).getString("fileds"))+"\'");
                sql.append("\'"+keyData.getJSONObject(i).getString(keys.getJSONObject(i).getString("fileds"))+"\'");
            }else {
                sql.append(keyData.getJSONObject(i).getString(keys.getJSONObject(i).getString("fileds")));
            }
            if (i!=keys.size()-1){
                sql.append(",");
            }
        }
        sql.append(");");
        return taskMapper.insertTaskData(sql.toString());
    }

}
