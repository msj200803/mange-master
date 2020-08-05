package com.stp.entity;

import java.io.Serializable;

/**
 * table1实体类
 */
public class Table1 implements Serializable {
    private String fields;
    private String element;
    private String whatisthis;

    public String getFields() {
        return fields;
    }

    public void setFields(String fields) {
        this.fields = fields;
    }

    public String getElement() {
        return element;
    }

    public void setElement(String element) {
        this.element = element;
    }

    public String getWhatisthis() {
        return whatisthis;
    }

    public void setWhatisthis(String whatisthis) {
        this.whatisthis = whatisthis;
    }

    @Override
    public String toString() {
        return "Table1{" +
                "fields='" + fields + '\'' +
                ", element='" + element + '\'' +
                ", whatisthis='" + whatisthis + '\'' +
                '}';
    }
}
