package com.zql.service;

import com.zql.model.WechatAccount;

/**
 * Created by 张启磊 on 2019-6-14.
 */
public interface WechatAccountService {
    WechatAccount selectByid(int accountId);
}
