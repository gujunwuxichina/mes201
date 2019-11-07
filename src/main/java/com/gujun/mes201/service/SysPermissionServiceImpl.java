package com.gujun.mes201.service;

import com.gujun.mes201.dao.SysPermissionMapper;
import com.gujun.mes201.entity.SysPermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysPermissionServiceImpl implements SysPermissionService {

    @Autowired
    private SysPermissionMapper sysPermissionMapper;

    @Override
    public List<SysPermission> listByRid(Integer rId) {
        return sysPermissionMapper.listByRid(rId);
    }

}
