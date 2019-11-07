package com.gujun.mes201;

import com.gujun.mes201.config.security.CustomUserDetails;
import com.gujun.mes201.config.security.CustomUserDetailsService;
import com.gujun.mes201.config.security.JwtTokenUtil;
import com.gujun.mes201.service.RoleService;
import io.jsonwebtoken.Claims;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Mes201ApplicationTests {

    private Logger logger= LoggerFactory.getLogger(getClass());

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Autowired
    private RoleService roleService;

    @Test
    public void encodePwd(){
        logger.info(passwordEncoder.encode("111111"));
    }

    @Test
    public void testToken01(){
        CustomUserDetails userDetails= (CustomUserDetails) customUserDetailsService.loadUserByUsername("admin");
        logger.info(userDetails.getPhone());
        logger.info(userDetails.getPassword());
//        Map<String, Object> claims=new HashMap<>();
//        claims.put("id","1");
//        String token=jwtTokenUtil.generateToken(userDetails,claims);
//        logger.info(token);
//        logger.info(jwtTokenUtil.validateToken(token,userDetails).toString());  //true
//
//        String u1=jwtTokenUtil.getUsernameFromToken(token);
//        logger.info(u1);

    }

    @Test
    public void testToken02(){
        String token="eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImlkIjoiMSIsImV4cCI6MTU3MzI2NDY3MSwiaWF0IjoxNTczMDkxODcxfQ.-mkTZd7Kh3oa-OO8g0bSdY96XwuJLL7rZ9eA5E_alWaMRR5T9dgGR4iK4zhCAtLIJRKEdYPNEo2Nrj9faotaeA";
        String username=jwtTokenUtil.getUsernameFromToken(token);
        Claims claims=jwtTokenUtil.getAllClaimsFromToken(token);
        logger.info(claims.get("id").toString());
        logger.info(username);
        logger.info(jwtTokenUtil.getExpirationDateFromToken(token).toString());
    }

    @Test
    public void testGetRolesByName(){
        Integer uId=7;
        List<String> roles=roleService.getNames(uId);
        System.out.println(roles);
    }

}
