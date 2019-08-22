package com.zql.dto;

import java.util.Date;

/**
 * @author: create
 * @description:
 * @date: 2019-8-8
 */
public class SysRole {
    private String roleName;
    //有效标志
    private Long enabled;
    private Long createBy;
    private Date createTime;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Long getEnabled() {
        return enabled;
    }

    public void setEnabled(Long enabled) {
        this.enabled = enabled;
    }

    public Long getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
