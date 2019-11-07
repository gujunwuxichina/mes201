package com.gujun.mes201.service;

import com.gujun.mes201.entity.SystemUser;

import java.util.List;

public interface UserService {

    SystemUser getById(Integer uId);

    SystemUser getByName(String username);

    List<SystemUser> getAll();

    int getCount();

    void deletePersistent(String username);

    void deletePersistentByUsername(String username);

}
