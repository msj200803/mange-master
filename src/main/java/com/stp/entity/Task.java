package com.stp.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Task {
    private Integer id;  //任务ID
    private String taskName;    //任务名称
    private String taskKeys;    //任务Key
    private String taskCreatUserId;     //创建任务的UserID
    private String taskAuthority;   //任务的权限
    private String taskFileUrl;     //任务的文件路径
    private String taskTag;     //任务的tag标签(JSON格式的数组)
    private Date createTime;    //创建时间
    private Date updateTime;    //修改时间
}
