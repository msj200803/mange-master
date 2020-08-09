package com.stp.entity;

import lombok.Data;

import javax.persistence.Table;
import java.io.Serializable;

/**
 * table1实体类
 */
@Data
@Table(name = "tb_table1")
public class tk_tn implements Serializable {
    private String fields;
    private String element;
    private String whatisthis;
}
