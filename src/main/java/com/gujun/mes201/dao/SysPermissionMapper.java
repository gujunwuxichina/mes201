package com.gujun.mes201.dao;

import com.gujun.mes201.entity.SysPermission;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysPermissionMapper {

    List<SysPermission> listByRid(Integer rId);

}
