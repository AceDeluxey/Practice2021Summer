package com.thymeleaf.demo.exception;

public class LoginException extends  RuntimeException {
    private  Integer code;
    private String msg;

    public LoginException() {
    }

    public LoginException(Integer code, String msg) {
        super(msg);
        this.code=code;

        this.msg = msg;
    }


    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
