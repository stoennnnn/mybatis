package com.zql.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zql.model.WechatAccount;
import com.zql.service.serviceImpl.WechatAccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by  @ZQL  on 2019/6/14.
 */
@RestController
@RequestMapping("/mybatis")
public class AccountController {
    @Autowired
    private WechatAccountServiceImpl service;
    @GetMapping("/pagehelper")
    public PageInfo<WechatAccount> getPageAccount(@RequestParam int pageNum){
        PageInfo<WechatAccount> pageInfo = service.selectByid(pageNum);
        return pageInfo;
    }
}
