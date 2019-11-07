package com.gujun.mes201.dao;

import com.gujun.mes201.entity.Role;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleMapper {

    Role getById(Integer rId);

    Role getByName(String rName);

    List<String> getNames(@Param("uId") Integer uId);

}
