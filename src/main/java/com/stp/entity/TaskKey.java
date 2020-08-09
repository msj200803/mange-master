package com.stp.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * table2实体类
 */
@Data
public class Table2 implements Serializable {
    private Integer id;
    private String EA;
    private String EB;
    private String PP;
    private String PN;
    private String R1;
    private String R2;
    private String R3;
    private String operator;    // 操作人员
    private String remarks;     // 备注
    private String createTime;    // 时间
}
