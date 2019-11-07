package com.gujun.mes201.config.security;

import com.gujun.mes201.entity.SystemUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class CustomUserDetails extends SystemUser implements UserDetails {

    private Collection<? extends GrantedAuthority> authorities;

    public CustomUserDetails(Integer uId, String username, String password, String phone,Collection<? extends GrantedAuthority> authorities) {
        super(uId, username, password, phone);
        this.authorities=authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }



    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
