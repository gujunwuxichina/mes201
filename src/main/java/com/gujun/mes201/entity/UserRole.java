package com.gujun.mes201.entity;

import org.apache.ibatis.type.Alias;

import java.io.Serializable;

@Alias("userRole")
public class UserRole implements Serializable {

    private static final long serialVersionUID = -404321738146952419L;

    private Integer uId;

    private Integer rId;

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public Integer getrId() {
        return rId;
    }

    public void setrId(Integer rId) {
        this.rId = rId;
    }

}
