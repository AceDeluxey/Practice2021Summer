package com.thymeleaf.demo.service.impl;

import com.thymeleaf.demo.dto.ResultDTO;
import com.thymeleaf.demo.entity.Admin;
import com.thymeleaf.demo.exception.LoginException;
import com.thymeleaf.demo.mapper.AdminMapper;
import com.thymeleaf.demo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private AdminMapper mapper;

    @Override
    public ResultDTO login(Admin admin, HttpSession session) {
        //数据校验

        Admin dbAdmin = mapper.findByName(admin.getAdminName());
        if(dbAdmin == null ){
//            return new ResultDTO(1001,"用户不存在！");
            throw new LoginException(1001,"用户不存在！");
        }
        if(dbAdmin.getAdminStatus() !=null && dbAdmin.getAdminStatus().equals(0)){
            throw new LoginException(1002,"用户被锁定！");
        }
        if(dbAdmin.getAdminPwd() !=null && !dbAdmin.getAdminPwd().equals(admin.getAdminPwd())){
            throw new LoginException(1003,"用户密码错误！");
        }
        session.setAttribute("adminName",admin.getAdminName());
        dbAdmin.setLastLoginTime(new Timestamp(System.currentTimeMillis()));
        mapper.update(dbAdmin);
        return new ResultDTO(200,"登录成功");
    }
}
