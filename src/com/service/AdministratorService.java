package com.service;


import com.entity.Administrator;

public interface AdministratorService {

    Administrator adminLogin(String adminName, String adminPassword) throws Exception;

    void adminRegister(String adminName, String adminPassword) throws Exception;

    String adminNameCheck(String adminName) throws Exception;
}
