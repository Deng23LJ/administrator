package com.controller;


import com.entity.PersonAffairs;
import com.service.PersonAffairsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class PersonAffairsController {



    @Autowired
    private PersonAffairsService personAffairsService;


    //所有个人事务申请详情
    @RequestMapping("personAffairs.do")
    public  Map<String,Object> findAllPersonAffairs(int page,int limit) throws Exception{
        List<PersonAffairs> personAffairsList = personAffairsService.findAllPersonAffairs(page,limit);
        int count = personAffairsService.findAllPersonAffairsCount();
        Map<String,Object> map=new HashMap<>();		//装填回调数据
        map.put("code", 0);
        map.put("msg", "个人事务");
        map.put("count", count);   //获得数据的总数
        map.put("data",personAffairsList);    //本次分页查询的数据
        return map;
    }

    @PostMapping("visaDealA.do")
    public void visaDealA(int departmentAAudit,String username) throws Exception{
        personAffairsService.visaDealA(departmentAAudit,username);
    }


    @PostMapping("visaDealB.do")
    public void visaDealB(int departmentBAudit,String username) throws Exception{
        personAffairsService.visaDealB(departmentBAudit,username);

    }

    //部门待审文件
    @RequestMapping("UnDealpersonAffairs.do")
    public List<PersonAffairs> findUnDealpersonAffairs(String section) throws Exception {
       List<PersonAffairs> UnDealpersonAffairsList =  personAffairsService.findUnDealpersonAffairs(section);
       return UnDealpersonAffairsList;
    }


    //个人业务服务审核
    @RequestMapping("agree.do")
    public String agree(HttpSession session,int id,String section) throws Exception {
        String name = (String) session.getAttribute("name");
        if (name!=null){
            if (section.equals("A")){
                return (personAffairsService.agreeUserServiceA(session,id));
            }else{
                return (personAffairsService.agreeUserServiceB(session,id));
            }
        }else{
            return "未登录";
        }
    }





}
