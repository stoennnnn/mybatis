package com.zql.service.serviceImpl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zql.mapper.WechatAccountMapper;
import com.zql.model.WechatAccount;
import com.zql.model.WechatAccountExample;
import com.zql.service.WechatAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 张启磊 on 2019-6-14.
 */
@Service
public class WechatAccountServiceImpl implements WechatAccountService{
    @Autowired
    private WechatAccountMapper wechatAccountMapper;
    @Override
    public PageInfo<WechatAccount> selectByid(int pageNum) {
        PageHelper.startPage(pageNum,4);
        WechatAccountExample example = new WechatAccountExample();
        List<WechatAccount> accounts = wechatAccountMapper.selectByExample(example);
        PageInfo<WechatAccount>  pageInfo = new PageInfo<>(accounts);
        return pageInfo;
    }
}
