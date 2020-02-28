package com.controller;


import com.entity.CorperateAffairs;
import com.service.CorperateAffairsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class CorperateAffairsController {
    @Autowired
    private CorperateAffairsService corperateAffairsService;

    //法人服务列表
    @PostMapping("CorperateAffairs.do")
    public List<CorperateAffairs> findAllCorperateAffairs() throws Exception{
       List<CorperateAffairs> corperateAffairsList =  corperateAffairsService.findAllCorperateAffairs();
        return corperateAffairsList;
    }

    //A部门批准
    @PostMapping("sectionA.do")
    public void sectionA(int sectionA,String legalPerson) throws Exception{
        corperateAffairsService.sectionA(sectionA,legalPerson);
    }

    //B部门批准
    @PostMapping("section.do")
    public void sectionB(int sectionB,String legalPerson) throws Exception{
        corperateAffairsService.sectionB(sectionB,legalPerson);

    }

}


