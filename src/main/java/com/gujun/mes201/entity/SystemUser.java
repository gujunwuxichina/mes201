package com.gujun.mes201.entity;

import org.apache.ibatis.type.Alias;

import java.io.Serializable;

@Alias("user")
public class SystemUser implements Serializable {

    private static final long serialVersionUID = 4134925776380649064L;

    private Integer uId;

    private String username;

    private String password;

    private String phone;

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public SystemUser(Integer uId, String username, String password, String phone) {
        this.uId = uId;
        this.username = username;
        this.password = password;
        this.phone = phone;
    }
}
