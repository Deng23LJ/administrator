package com.service;


import com.controller.Administrator;

public interface AdministratorService {

    Administrator adminLogin(String adminName, String adminPassword);

    void adminRegister(String adminName, String adminPassword, int adminGrade);
}
