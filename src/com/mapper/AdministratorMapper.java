package com.mapper;

import com.controller.Administrator;

import java.util.Map;

public interface AdministratorMapper {
    Administrator adminLogin(Map<String,Object> map);

    void adminRegister(Map<String,Object> map);
}
