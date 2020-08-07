package com.stp.entity;

import lombok.Data;

import java.util.Date;
@Data
public class Group {
    private Integer id;  //组的ID
    private String groupName;  //组的名字
    private String groupAuthority;  //组的权限
}
