package com.gujun.mes201.service;

import com.gujun.mes201.dao.UserRoleMapper;
import com.gujun.mes201.entity.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRoleServiceImpl implements UserRoleService {

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Override
    public List<UserRole> listById(Integer uId) {
        return userRoleMapper.listById(uId);
    }
}
