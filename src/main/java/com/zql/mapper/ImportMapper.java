package com.zql.mapper;

import com.zql.model.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author: create
 * @description:
 * @date: 2019-8-22
 */
@Mapper
public interface ImportMapper {

    void addUser(User sysUser);

    int updateUserByName(User sysUser);

    int selectByName(String name);
}
