package com.stp.controller;

import com.alibaba.fastjson.JSONObject;
import com.stp.entity.Task;
import com.stp.result.Result;
import com.stp.service.TaskService;
import com.stp.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.file.Paths;

@Controller
@RequestMapping("/useTask")
@CrossOrigin
public class UseTaskController {
    @Autowired
    TaskService service;
    @RequestMapping("/getTask")
    @ResponseBody
    public Result getTask(Integer taskId) throws IOException {
        // 获得对象并且将url转成真正的数据返回给前端
        Task taskById = service.getTaskById(taskId);
        taskById.setTaskFileUrl(FileUtil.readFile(Paths.get(taskById.getTaskFileUrl())));
        return Result.success(taskById);
    }
        @RequestMapping(value = "/insertData",method = RequestMethod.POST)
    @ResponseBody
    public Result insertTaskData(@RequestBody JSONObject jsonObject,Integer taskId) throws IOException {
        return Result.success(service.insertDataByTaskId(jsonObject,taskId,jsonObject.getString("fileData")));
    }
}
