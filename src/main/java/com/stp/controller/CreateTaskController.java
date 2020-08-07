package com.stp.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.stp.entity.Group;
import com.stp.entity.Task;
import com.stp.info.TaskInfo;
import com.stp.result.Result;
import com.stp.mapper.GroupMapper;
import com.stp.service.GroupService;
import com.stp.service.TaskService;
import com.stp.service.UserService;
import com.stp.util.FileUtil;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Controller
@RequestMapping("/createTask")
@CrossOrigin
public class CreateTaskController {
    @Autowired
    GroupService groupService;
    @Autowired
    UserService userService;
    @Autowired
    TaskService taskService;
    Logger logger = LoggerFactory.getLogger(CreateTaskController.class);
    @ResponseBody
    @RequestMapping("/getGroup")
    public Result getGroup(){
        //返回全部组类型
        logger.info("获取全部组的类型");
        return Result.success( groupService.getGroups());
    }

    @ResponseBody
    @RequestMapping("/getUsers")
    public Result getUsers(){
        //返回组里的全部人
        logger.info("获取全部人");
        return Result.success(userService.getUsers());
    }
    @ResponseBody
    @RequestMapping(value = "/createTask",method = RequestMethod.POST)
    public Result addTask(HttpServletRequest request) throws IOException {
        //先获得file的request类
        MultipartHttpServletRequest params=((MultipartHttpServletRequest) request);
        List<MultipartFile> files = ((MultipartHttpServletRequest) request)
                .getFiles("file");
        //获得传过来的参数
        //  name代表这个任务的名字
        //  keys代表全部key的JSON数组
        //  authority代表权限
        //  authority:{
        //      group:[1]代表id为1的组全部都可以查看,
        //      users:[1]代表id为1的user可以查看
        //  }
        String name = request.getParameter("name");
        String keys = request.getParameter("keys");
        String authority = request.getParameter("authority");
        Task newWestTask = taskService.getNewWestTask();
        logger.info(JSONObject.toJSONString(newWestTask));
        // 判断重复提交(比较简易版本)
        logger.info(name);
        logger.info(newWestTask.getTaskName());
        logger.info(String.valueOf(name.equals(newWestTask.getTaskName())));
        if (name.equals(newWestTask.getTaskName())){
            return Result.error("重复提交");
        }
        // fileUrl存的是文件的位置
        String fileUrl = null;
        logger.info(name);
        logger.info(keys);
        logger.info(authority);
        logger.info(String.valueOf(files.size()));
        //存储file 现在只能让他存一个
        for (int i = 0; i < files.size(); i++) {
            MultipartFile multipartFile = files.get(i);
            fileUrl = "D://testc/"+name+"/"+multipartFile.getResource().getFilename();
            FileUtil.saveFile(multipartFile.getInputStream(), fileUrl);
        }
        // 得到并且执行任务的sql建表语句
        String sql = taskService.generateSQL(keys, name);
        taskService.createTaskTable(sql);
        Task task = new Task();
        task.setTaskAuthority(authority);
        task.setTaskFileUrl(fileUrl);
        task.setTaskKeys(keys);
        task.setTaskTag(taskService.getAbbreviation(keys));
        // 这是存用户ID的暂时先不开
        //task.setTaskCreatUserId();
        task.setTaskName(name);
        // 存储任务到任务中心
        taskService.insertTask(task);
        return Result.success(true);
    }


}
