package com.gujun.mes201.advice;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice(basePackages = {"com.gujun.mes201.controller.*"},annotations = {RestController.class, Controller.class})
public class ControllerExceptionAdvice {

    private Logger logger=LoggerFactory.getLogger(ControllerExceptionAdvice.class);

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public JSONObject exceptionHandler(Exception ex){
        ex.printStackTrace();
        logger.info(ex.getMessage());
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("message","error");
        return jsonObject;
    }

}
