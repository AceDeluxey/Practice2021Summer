package com.thymeleaf.demo.exception;

import com.thymeleaf.demo.dto.ResultDTO;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MyExceptionAdvice {
    /**
     *
     * @return
     */
    @ExceptionHandler(LoginException.class)
    public ResultDTO loginExceptionHandler(LoginException e){

        return new ResultDTO(e.getCode(),e.getMsg());
    }

    @ExceptionHandler(Exception.class)
    public ResultDTO exceptionHander(Exception e ){
        //记录异常日志，异常日志对于系统来说很重要

        return new ResultDTO(1002,e.getMessage());
    }
}
