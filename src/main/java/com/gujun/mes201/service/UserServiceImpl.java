package com.gujun.mes201.service;

import com.gujun.mes201.dao.UserMapper;
import com.gujun.mes201.entity.SystemUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public SystemUser getById(Integer uId) {
        return userMapper.getById(uId);
    }

    @Override
    public SystemUser getByName(String username) {
        return userMapper.getByName(username);
    }

    @Override
    public List<SystemUser> getAll() {
        return userMapper.getAll();
    }

    @Override
    public int getCount() {
        return userMapper.getCount();
    }

    @Override
    public void deletePersistent(String username) {
        userMapper.deletePersistent(username);
    }

    @Override
    public void deletePersistentByUsername(String username) {
        userMapper.deletePersistentByUsername(username);
    }

}
