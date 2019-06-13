package com.zql.service.serviceImpl;

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
    public WechatAccount selectByid(int accountId) {
        WechatAccountExample example = new WechatAccountExample();
        WechatAccountExample.Criteria criteria = example.createCriteria();
        criteria.andAccountIdEqualTo(accountId);
        List<WechatAccount> wechatAccounts = wechatAccountMapper.selectByExample(example);
        return null;
    }
}
