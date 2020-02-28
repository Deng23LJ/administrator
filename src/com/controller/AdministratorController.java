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
    public int adminLogin(HttpSession session, String adminName, String adminPassword) throws Exception {
        Administrator login = administratorService.adminLogin(adminName, adminPassword);
        if (login != null) {
            session.setAttribute("name",login.getAdminName());
            return 1;
        } else {
            return 0;
        }
    }

    //注册管理员
    @RequestMapping("registerAdmin.do")
    public int adminRegister(String adminName, String adminPassword) throws Exception {
        int regist = administratorService.adminRegister(adminName, adminPassword);
        System.out.println("service+"+regist);
        if (regist == 1) {
            return 1;
        } else {
            return 0;
        }
    }

    //注册检查
    @PostMapping("adminNameCheck.do")
    public String adminNameCheck(String adminName) throws Exception {
        System.out.println(adminName);
        String result = administratorService.adminNameCheck(adminName);

        return result;

    }
}
