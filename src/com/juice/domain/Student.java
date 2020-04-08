package com.juice.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter@Setter
public class Student {

    private String name;
    private Integer id;
    private Date entry_time;
    private Date leave_time;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", entry_time=" + entry_time +
                ", leave_time=" + leave_time +
                '}';
    }
}
