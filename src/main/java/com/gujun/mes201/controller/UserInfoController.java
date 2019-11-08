package com.gujun.mes201.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gujun.mes201.entity.PageData;
import com.gujun.mes201.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("userInfo")
public class UserInfoController {

    private Logger logger= LoggerFactory.getLogger(getClass());

    @Autowired
    private UserService userService;

    @PostMapping("/list")
    public JSONObject list(@RequestBody PageData pd){
        JSONObject jsonObject=new JSONObject();
        PageHelper.startPage(Integer.parseInt(pd.get("page").toString()),Integer.parseInt(pd.get("limit").toString()),"a.uId asc"); //默认排序
        List<PageData> users=userService.list(pd);
        PageInfo<PageData> pageInfo=new PageInfo<>(users);
        jsonObject.put("items",users);
        jsonObject.put("total",pageInfo.getTotal());
        jsonObject.put("code",20000);
        return jsonObject;
    }

}
