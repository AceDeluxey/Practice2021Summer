package com.thymeleaf.demo.entity;

import java.sql.Timestamp;

public class MyParam {

    private String keywords;
    private Integer status;
    private String startTime;
    private String endTime;

    public MyParam() {
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getKeywords() {
        return keywords;
    }

    public Integer getStatus() {
        return status;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    @Override
    public String toString() {
        return "Param{" +
                "keywords='" + keywords + '\'' +
                ", status=" + status +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}
