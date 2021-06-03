package com.thymeleaf.demo.controller;

import com.sun.org.apache.xpath.internal.operations.Bool;
import com.thymeleaf.demo.entity.Admin;
import com.thymeleaf.demo.mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private AdminMapper mapper;

    /**
     * 登录页面
     * @return
     */
    @GetMapping("/page")
    public String loginPage(){
        System.out.print(123);
        return "login";
    }

    @PostMapping ("/page")
    public String loginParams(String username, String password){
        Admin admin = new Admin();
        Admin paraAdmin  = new Admin();
        paraAdmin.setAdminName(username);
        paraAdmin.setAdminPwd(password);
        admin=mapper.checkPwd(paraAdmin);
        if(admin!=null){
            return  "redirect:/index";
        } else{
            return "login";
        }

    }
}