package com.thymeleaf.demo.service;

import com.thymeleaf.demo.dto.ResultDTO;
import com.thymeleaf.demo.entity.Admin;

import javax.servlet.http.HttpSession;

/*
    登录服务的接口
 */
public interface LoginService {
//    方便拓展，后续如果加入其他登录方式可以容易拓展，代码结构更清晰
    /**
     * 用户登录
     * @param admin
     * @return
     */
    ResultDTO login(Admin admin, HttpSession session);
}
