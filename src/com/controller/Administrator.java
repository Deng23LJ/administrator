package com.controller;


import com.entity.JsonResult;
import com.service.AdministratorService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Administrator {

    private AdministratorService administratorService;

    //登录管理
    @PostMapping("adminLogin.do")
    public int adminLogin(String adminName ,String adminPassword){
          Administrator result = administratorService.adminLogin(adminName,adminPassword);
          if(result!=null){
              return 1;
          }else{
              return 0;
          }
    }

    //注册管理员
    @PostMapping("registerAdmin.do")
    public JsonResult adminRegister(String adminName, String adminPassword, int adminGrade){
    try {
        administratorService.adminRegister(adminName,adminPassword,adminGrade);
        return new JsonResult(true,"注册成功！");
    }catch (Exception e){
        e.printStackTrace();
    }
    return new JsonResult(false,"注册失败!");
    }
}
