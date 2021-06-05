package com.thymeleaf.demo.controller;

import com.thymeleaf.demo.dto.ResultDTO;
import com.thymeleaf.demo.entity.Admin;
import com.thymeleaf.demo.mapper.AdminMapper;
import com.thymeleaf.demo.service.impl.LoginServiceImpl;
import com.thymeleaf.demo.util.ValidatorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/login")
public class LoginController {

//    @Autowired
//    private AdminMapper mapper;

    @Autowired
    private LoginServiceImpl loginService;

    /**
     * 登录页面
     * @return
     */
    @GetMapping("/page")
    public String loginPage(){
        return "login";
    }

    @PostMapping("/niu")
    @ResponseBody
    public ResultDTO login(@Validated Admin admin, BindingResult bindingResult, HttpSession session) throws Exception {
        //数据校验在这里也行
        ValidatorUtil.showMsg(bindingResult);
        return loginService.login(admin,session);
    }
    //  退出登录
    @GetMapping("/out")
    public String logout(HttpSession session){
        session.removeAttribute("adminName");
        return "login";
    }

//    @PostMapping ("/page")
//    public String loginParams(String username, String password){
//        Admin admin = new Admin();
//        Admin paraAdmin  = new Admin();
//        paraAdmin.setAdminName(username);
//        paraAdmin.setAdminPwd(password);
//        admin=mapper.findByName(paraAdmin);
//        if(admin!=null){
//            return  "redirect:/index";
//        } else{
//            return "login";
//        }
//
//    }
}