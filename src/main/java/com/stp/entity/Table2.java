package com.stp.entity;

import java.io.Serializable;

/**
 * table2实体类
 */
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEA() {
        return EA;
    }

    public void setEA(String EA) {
        this.EA = EA;
    }

    public String getEB() {
        return EB;
    }

    public void setEB(String EB) {
        this.EB = EB;
    }

    public String getPP() {
        return PP;
    }

    public void setPP(String PP) {
        this.PP = PP;
    }

    public String getPN() {
        return PN;
    }

    public void setPN(String PN) {
        this.PN = PN;
    }

    public String getR1() {
        return R1;
    }

    public void setR1(String r1) {
        R1 = r1;
    }

    public String getR2() {
        return R2;
    }

    public void setR2(String r2) {
        R2 = r2;
    }

    public String getR3() {
        return R3;
    }

    public void setR3(String r3) {
        R3 = r3;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Table2{" +
                "id=" + id +
                ", EA='" + EA + '\'' +
                ", EB='" + EB + '\'' +
                ", PP='" + PP + '\'' +
                ", PN='" + PN + '\'' +
                ", R1='" + R1 + '\'' +
                ", R2='" + R2 + '\'' +
                ", R3='" + R3 + '\'' +
                ", operator='" + operator + '\'' +
                ", remarks='" + remarks + '\'' +
                ", createTime='" + createTime + '\'' +
                '}';
    }
}
