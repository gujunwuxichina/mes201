package com.gujun.mes201.service;

import com.gujun.mes201.dao.RoleMapper;
import com.gujun.mes201.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public Role getById(Integer rId) {
        return roleMapper.getById(rId);
    }

    @Override
    public Role getByName(String rName) {
        return roleMapper.getByName(rName);
    }

    @Override
    public List<String> getNames(Integer uId) {
        return roleMapper.getNames(uId);
    }

}
