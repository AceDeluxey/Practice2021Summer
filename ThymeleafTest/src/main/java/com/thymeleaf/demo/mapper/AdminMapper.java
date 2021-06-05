package com.thymeleaf.demo.mapper;

import com.thymeleaf.demo.entity.Admin;
import com.thymeleaf.demo.entity.MyParam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/*
    mapper用于增删改查
 */
@Mapper
public interface AdminMapper {
    /*
        查询所有数据
        @return
     */
    List<Admin> findAll();

    List<Admin> findByParam(@Param("param") MyParam myParam);

    void save (@Param("admin") Admin admin );

    void saveByBatch(@Param("list") List<Admin> list);
    //    真删除
    void deleteTrue(@Param("id") Integer id );

    // 软删除（重要数据不能直接删除）
    void deleteFalse(@Param("id") Integer id);

    //    批量删除
    void deleteByBatch(@Param("list") List<Integer> idList);
    //    修改
    void update(@Param("admin") Admin admin );

    /*
        通过主键查询
        @return
     */
    Admin findByPk(@Param("id") Integer id);

    Admin findByName(@Param("adminName") String adminName);
}
