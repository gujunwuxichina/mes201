package com.gujun.mes201.dao;

import com.gujun.mes201.entity.PageData;
import com.gujun.mes201.entity.SystemUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {

    SystemUser getById(Integer uId);

    SystemUser getByName(String username);

    List<SystemUser> getAll();

    int getCount();

    List<PageData> list(PageData pd);

}
