package com.zql.mapper;

import com.zql.model.WechatAccount;
import com.zql.model.WechatAccountExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface WechatAccountMapper {
    long countByExample(WechatAccountExample example);

    int deleteByExample(WechatAccountExample example);

    int insert(WechatAccount record);

    int insertSelective(WechatAccount record);

    List<WechatAccount> selectByExample(WechatAccountExample example);

    int updateByExampleSelective(@Param("record") WechatAccount record, @Param("example") WechatAccountExample example);

    int updateByExample(@Param("record") WechatAccount record, @Param("example") WechatAccountExample example);
}