package com.gujun.mes201.entity;

import org.apache.ibatis.type.Alias;

import java.io.Serializable;

@Alias("role")
public class Role implements Serializable {

    private static final long serialVersionUID = 5533776991831637971L;

    private Integer rId;

    private String rName;

    public Integer getrId() {
        return rId;
    }

    public void setrId(Integer rId) {
        this.rId = rId;
    }

    public String getrName() {
        return rName;
    }

    public void setrName(String rName) {
        this.rName = rName;
    }

}
