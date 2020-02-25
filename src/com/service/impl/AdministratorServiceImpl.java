package com.service.impl;


import com.controller.AdministratorController;
import com.entity.Administrator;
import com.mapper.AdministratorMapper;
import com.service.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AdministratorServiceImpl implements AdministratorService {


    @Autowired
    private AdministratorMapper administratorMapper;

    @Override
    public Administrator adminLogin(String adminName, String adminPassword) throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("adminName", adminName);
        map.put("adminPassword", adminPassword);
        return administratorMapper.adminLogin(map);
    }

    @Override
    public int adminRegister(String adminName, String adminPassword) throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("adminName", adminName);
        map.put("adminPassword", adminPassword);
        try {
            administratorMapper.adminRegister(map);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public String adminNameCheck(String adminName) throws Exception {
        return administratorMapper.adminNameCheck(adminName);
    }
}
