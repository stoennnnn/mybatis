package com.zql.model;

import lombok.Data;

/**
 * @author: create by zql
 * @description:
 * @date: 2019-8-1
 */
@Data
public class TimeConvert {
    private Integer id;
    private String Time;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }
}
