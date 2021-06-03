package com.thymeleaf.demo.entity;


import java.sql.Timestamp;

public class Admin {

  private Integer id;
  private String adminName;
  private String adminPwd;
  private Long adminPhone;
  private Timestamp lastLoginTime;
  private Timestamp createTime;
  private Timestamp updateTime;
  private Integer adminStatus;
  private Integer idDeleted;
  public Admin() {
  }

  public Integer getIdDeleted() {
    return idDeleted;
  }

  public void setIdDeleted(Integer idDeleted) {
    this.idDeleted = idDeleted;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }


  public String getAdminName() {
    return adminName;
  }

  public void setAdminName(String adminName) {
    this.adminName = adminName;
  }


  public String getAdminPwd() {
    return adminPwd;
  }

  public void setAdminPwd(String adminPwd) {
    this.adminPwd = adminPwd;
  }


  public Long getAdminPhone() {
    return adminPhone;
  }

  public void setAdminPhone(Long adminPhone) {
    this.adminPhone = adminPhone;
  }


  public Timestamp getLastLoginTime() {
    return lastLoginTime;
  }

  public void setLastLoginTime(Timestamp lastLoginTime) {
    this.lastLoginTime = lastLoginTime;
  }


  public Timestamp getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Timestamp createTime) {
    this.createTime = createTime;
  }


  public Timestamp getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(Timestamp updateTime) {
    this.updateTime = updateTime;
  }


  public Integer getAdminStatus() {
    return adminStatus;
  }

  public void setAdminStatus(Integer adminStatus) {
    this.adminStatus = adminStatus;
  }

  @Override
  public String toString() {
    return "Admin{" +
            "id=" + id +
            ", adminName='" + adminName + '\'' +
            ", adminPwd='" + adminPwd + '\'' +
            ", adminPhone=" + adminPhone +
            ", lastLoginTime=" + lastLoginTime +
            ", createTime=" + createTime +
            ", updateTime=" + updateTime +
            ", adminStatus=" + adminStatus +
            ", idDeleted=" + idDeleted +
            '}';
  }
}
