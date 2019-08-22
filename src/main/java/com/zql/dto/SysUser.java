package com.zql.dto;

import java.util.Date;

/**
 * @author: create
 * @description:
 * @date: 2019-8-8
 */
public class SysUser {
    private Long id;
    private String userName;
    private String userPassword;
    private String userEmail;
    private String userInfo;
    private Byte[] headImg;
    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUser_name() {
        return userName;
    }

    public void setUser_name(String user_name) {
        this.userName = user_name;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(String userInfo) {
        this.userInfo = userInfo;
    }

    public Byte[] getHeadImg() {
        return headImg;
    }

    public void setHeadImg(Byte[] headImg) {
        this.headImg = headImg;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
