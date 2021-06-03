package com.thymeleaf.demo.controller;

import com.thymeleaf.demo.dto.ResultDTO;
import com.thymeleaf.demo.entity.Admin;
import com.thymeleaf.demo.mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class IndexController {
//    Autowired表示直接从spring启动时放入的容器中取出对象，不重新创建
    @Autowired
    private AdminMapper mapper;


    /**
     * 主页的方法
     * @return
     */
    @GetMapping({"/index","/"})
    public String index(){
        return "index";
    }

    /**
     * 欢迎页
     * @return
     */
    @GetMapping("/welcome")
    public String  welcome(){
        return "welcome";
    }
    @RequestMapping("/index2")
    public String showIndex(Model model,String test){
        model.addAttribute("message", "HelloWorld"+test);
        return "index2";
    }


    @RequestMapping("/index/dto")
    public ResultDTO showIndex2(String test){
        ResultDTO result=new ResultDTO(123,"success","123");
//        model.addAttribute("message",result.getCode());
        return result;
    }

//    @RequestMapping("/index/submit")
//    public String showIndex3(Model model,Integer id){
//        List<Admin> admins = mapper.findAll();
//        Admin admin=admins.get(0);
//
//        model.addAttribute("data",admin.getAdminName());
//        return "index2";
//    }
//
//    @RequestMapping("/index/para")
//    public String showIndex2(@RequestParam(required = false,name="fake")String test, Model model ){
//        model.addAttribute("message",test);
//        return "index2";
//    }
}
