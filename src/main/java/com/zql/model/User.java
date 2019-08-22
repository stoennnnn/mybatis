package com.zql.model;

import lombok.Data;

import java.util.Date;

/**
 * @author: create
 * @description:
 * @date: 2019-8-22
 */
@Data
public class User {
    private Integer id;

    private String name;

    private String phone;

    private String address;

    private Date enrolDate;

    private String des;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getEnrolDate() {
        return enrolDate;
    }

    public void setEnrolDate(Date enrolDate) {
        this.enrolDate = enrolDate;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

}
