package com.service.impl;


import com.controller.Administrator;
import com.mapper.AdministratorMapper;
import com.service.AdministratorService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AdministratorImpl implements AdministratorService {

    private AdministratorMapper administratorMapper;
    @Override
    public Administrator adminLogin(String adminName, String adminPassword) {
        Map<String,Object> map = new HashMap<>();
        map.put("adminName",adminName);
        map.put("adminPassword",adminPassword);
        return administratorMapper.adminLogin(map);
    }

    @Override
    public void adminRegister(String adminName, String adminPassword, int adminGrade) {
        Map<String,Object> map = new HashMap<>();
        map.put("adminName",adminName);
        map.put("adminPassword",adminPassword);
        map.put("adminGrade",adminGrade);
        administratorMapper.adminRegister(map);
    }
}
