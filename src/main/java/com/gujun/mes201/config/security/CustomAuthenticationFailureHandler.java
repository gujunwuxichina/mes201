package com.gujun.mes201.config.security;

import com.alibaba.fastjson.JSONObject;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
        response.setContentType("application/json;charset=UTF-8");
        JSONObject jsonObject=new JSONObject();
        AuthenticationException exp = (AuthenticationException) request.getSession().getAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
        switch (exp.getClass().getSimpleName()){
            case "BadCredentialsException":
                jsonObject.put("result","passwordError");
                break;
            case "UsernameNotFoundException":
                jsonObject.put("result","usernameError");
                break;
            default:
        }
        response.getWriter().write(jsonObject.toJSONString());
    }

}
