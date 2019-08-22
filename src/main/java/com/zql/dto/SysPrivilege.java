package com.zql.dto;

/**
 * @author: create
 * @description:
 * @date: 2019-8-8
 */
public class SysPrivilege {
      private String privilegeName;
      private String privilegeUrl;

    public String getPrivilegeName() {
        return privilegeName;
    }

    public void setPrivilegeName(String privilegeName) {
        this.privilegeName = privilegeName;
    }

    public String getPrivilegeUrl() {
        return privilegeUrl;
    }

    public void setPrivilegeUrl(String privilegeUrl) {
        this.privilegeUrl = privilegeUrl;
    }
}
