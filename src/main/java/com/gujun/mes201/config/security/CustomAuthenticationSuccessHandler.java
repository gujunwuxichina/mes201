package com.gujun.mes201.config.security;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
public class CustomAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        CustomUserDetails userDetails= (CustomUserDetails) authentication.getPrincipal();
        Map<String, Object> claims=new HashMap<>();
        claims.put("uId",userDetails.getuId());
        claims.put("username",userDetails.getUsername());
        claims.put("phone",userDetails.getPhone());
        response.setContentType("application/json;charset=UTF-8");
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("result","loginSuccess");
        jsonObject.put("token",jwtTokenUtil.generateToken(userDetails,claims));
        jsonObject.put("code",20000);
        response.getWriter().write(jsonObject.toJSONString());
    }

}
