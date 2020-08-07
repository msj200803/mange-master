package com.stp.info;

import lombok.Data;


//Info代表就是controller的入参
@Data
public class TaskInfo {
    private String keys;
    private String authority;
    private String name;
}
