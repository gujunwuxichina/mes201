package com.gujun.mes201.dao;

import com.gujun.mes201.entity.UserRole;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRoleMapper {

    List<UserRole> listById(Integer uId);

}
