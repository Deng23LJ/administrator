package com.controller;


import com.entity.Administrator;
import com.entity.JsonResult;
import com.service.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.servlet.http.HttpSession;


@RestController
public class AdministratorController {


    @Autowired
    private AdministratorService administratorService;

    //登录管理
    @RequestMapping("adminLogin.do")
    public int adminLogin(HttpSession session, String adminName , String adminPassword) throws Exception {
        System.out.println(adminName);
        System.out.println(adminPassword);
        Administrator login = administratorService.adminLogin(adminName,adminPassword);
        if(login!=null){
//              session.setAttribute("name",LoginResult.getAdminName());
              return 1;
          }else{
              return 0;
          }
    }

    //注册管理员
    @RequestMapping("registerAdmin.do")
    public String adminRegister(String adminName, String adminPassword){
    try {
        administratorService.adminRegister(adminName,adminPassword);
        System.out.println(1);
        return "注册成功";
    }catch (Exception e){
        e.printStackTrace();
    }
        System.out.println(0);
       return "注册失败";
    }

    //注册检查
    @PostMapping("adminNameCheck.do")
    public String adminNameCheck(String adminName) throws  Exception{
       String result= administratorService.adminNameCheck(adminName);
        return result;
    }
}
