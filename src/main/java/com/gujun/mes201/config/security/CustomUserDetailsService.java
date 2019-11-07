package com.gujun.mes201.config.security;

import com.gujun.mes201.entity.Role;
import com.gujun.mes201.entity.SystemUser;
import com.gujun.mes201.entity.UserRole;
import com.gujun.mes201.service.RoleService;
import com.gujun.mes201.service.UserRoleService;
import com.gujun.mes201.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.List;

@Service(value = "customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SystemUser user=userService.getByName(username);
        if(user==null){
            throw new UsernameNotFoundException("用户不存在");
        }
        Collection<GrantedAuthority> authorities=new ArrayDeque<>();
        return new CustomUserDetails(user.getuId(),user.getUsername(),user.getPassword(),user.getPhone(),authorities);
    }

}
