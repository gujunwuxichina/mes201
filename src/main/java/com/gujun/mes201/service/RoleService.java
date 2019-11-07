package com.gujun.mes201.service;


import com.gujun.mes201.entity.Role;

import java.util.List;

public interface RoleService {

    Role getById(Integer rId);

    Role getByName(String rName);

    List<String> getNames(Integer uId);

}
