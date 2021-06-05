package com.thymeleaf.demo.dto;

public class ResultDTO {
    private Integer code;

    private String msg;

    private Object data;

    public ResultDTO() {
    }

    public ResultDTO(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public ResultDTO(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public Object getData() {
        return data;
    }

    public String getMsg() {
        return msg;
    }
}
