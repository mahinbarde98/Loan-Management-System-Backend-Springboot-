package com.cts.management.service;

import com.cts.management.dao.LoanDao;
import com.cts.management.dao.RoleDao;
import com.cts.management.entity.Loan;
import com.cts.management.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleService {

    @Autowired
    private RoleDao roleDao;


    public Role createNewRole(Role role){
        return roleDao.save(role);
    }

}
