package com.mapper;

import com.controller.AdministratorController;
import com.entity.Administrator;

import java.util.Map;

public interface AdministratorMapper {
    Administrator adminLogin(Map<String,Object> map) throws Exception;

    void adminRegister(Map<String,Object> map) throws Exception;

    String adminNameCheck(String adminName) throws Exception;
}
