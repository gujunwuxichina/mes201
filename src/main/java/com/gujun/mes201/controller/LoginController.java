package com.gujun.mes201.controller;

import com.alibaba.fastjson.JSONObject;
import com.gujun.mes201.config.security.JwtTokenUtil;
import com.gujun.mes201.service.RoleService;
import io.jsonwebtoken.Claims;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.WebAttributes;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class LoginController {

    private Logger logger= LoggerFactory.getLogger(getClass());

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private RoleService roleService;

    @PostMapping("/loginFail")
    public JSONObject loginFail(HttpServletRequest request){
        JSONObject jsonObject=new JSONObject();
        AuthenticationException exp = (AuthenticationException) request.getAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
        switch (exp.getClass().getSimpleName()){
            case "UsernameNotFoundException":
                jsonObject.put("message","usernameError");
                break;
            case "BadCredentialsException":
                jsonObject.put("message","passwordError");
                break;
            default:
        }
        return jsonObject;
    }

    @GetMapping("/getInfo")
    public JSONObject getInfo(String token){
        logger.info(token);
        JSONObject jsonObject=new JSONObject();
        Claims claims=jwtTokenUtil.getAllClaimsFromToken(token);
        Integer uId= (Integer) claims.get("uId");
        String name= (String) claims.get("username");
        List<String> roles=roleService.getNames(uId);
        jsonObject.put("code",20000);
        jsonObject.put("roles",roles);
        jsonObject.put("introduction","my name is "+name);
        jsonObject.put("avatar","https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        jsonObject.put("name",name);
        return jsonObject;
    }

}
