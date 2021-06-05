package com.thymeleaf.demo;

import com.thymeleaf.demo.entity.Admin;
import com.thymeleaf.demo.entity.MyParam;
import com.thymeleaf.demo.mapper.AdminMapper;
import org.apache.ibatis.annotations.Param;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class ThymeleafTestApplicationTests {
    @Autowired
    private AdminMapper mapper;


    @Test
    public void testFinByName(){
        String name="admin";
        mapper.findByName(name);
    }
    @Test
    public void testFindAll(){
        List<Admin> admins = mapper.findAll();

        for(Admin admin : admins){
            System.out.print(admin);
        }
    }
    @Test
    public void testFindOne(){
        Admin admin = mapper.findByPk(2);
        System.out.println(admin);
    }
    @Test
    public void testInsert(){
        Admin admin = new Admin();
        admin.setId(4);
        admin.setAdminPwd("123");
        admin.setAdminName("admin666");
        admin.setAdminPhone(12344445555L);
        admin.setCreateTime(new Timestamp(System.currentTimeMillis()));
        mapper.save(admin);
    }
    @Test
    public void testInsertByBatch(){
        List<Admin> list = new ArrayList<Admin>();
        Admin admin = new Admin();
        admin.setAdminPwd("123456");
        admin.setAdminName("admin999");
        admin.setAdminPhone(12344449999L);
        admin.setCreateTime(new Timestamp(System.currentTimeMillis()));
        Admin admin2 = new Admin();
        admin2.setAdminPwd("888888");
        admin2.setAdminName("admin8888");
        admin2.setAdminPhone(12344449999L);
        admin2.setCreateTime(new Timestamp(System.currentTimeMillis()));
        list.add(admin);
        list.add(admin2);
        mapper.saveByBatch(list);
    }
    @Test
    public void testDeleteByBatch(){
        List<Integer> list = new ArrayList<Integer>();
        list.add(6);
        list.add(7);
        mapper.deleteByBatch(list);
    }
    @Test
    public void testUpdate(){
        Admin admin = new Admin();
        admin.setId(4);
        admin.setAdminPwd("123423");
        admin.setAdminName("admin666");
        admin.setAdminPhone(12399998888L);
        admin.setUpdateTime(new Timestamp(System.currentTimeMillis()));
        mapper.update(admin);
    }
    @Test
    public void testFindParam(){
        MyParam myParam = new MyParam();

    }

    @Test
    void contextLoads() {
    }

}
