package com.gujun.mes201.service;

import com.gujun.mes201.entity.SysPermission;

import java.util.List;

public interface SysPermissionService {

    List<SysPermission> listByRid(Integer rId);

}
