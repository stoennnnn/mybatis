package com.zql.mapper;

import com.zql.dto.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author: create
 * @description:
 * @date: 2019-8-8
 */
@Mapper
public interface UserMapper {
    /**
     *
     * @return
     */
    List<SysUser> selectUserByName(@Param( "userName" ) String userName,@Param( "userEmail" )String userEmail);
}
