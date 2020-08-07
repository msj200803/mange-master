package com.stp.entity;

import lombok.Data;

@Data
public class User {
    //暂未开发
    private Integer id;   //ID
    private String userId;  //用户ID(我们自己生成)
    private String userAccount;  //用户账号
    private String userPassword;    //用户密码
    private String userName;    //用户昵称
    private String userAuthority;   //用户权限
//    private Group group;
}
