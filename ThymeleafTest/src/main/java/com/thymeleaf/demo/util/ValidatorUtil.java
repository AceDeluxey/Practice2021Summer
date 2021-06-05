package com.thymeleaf.demo.util;

import com.thymeleaf.demo.dto.ResultDTO;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import java.util.List;

public class ValidatorUtil {
    /**
     *
     * @param bindingResult
     */
    public static void showMsg(BindingResult bindingResult) throws Exception {
        //获取所有错误
        List<ObjectError> allErrors =bindingResult.getAllErrors();
        for(ObjectError error: allErrors){
            throw new Exception(error.getDefaultMessage());
        }
    }
}
