package com.service.impl;

import com.entity.PersonAffairs;
import com.mapper.PersonAffairsMapper;
import com.service.PersonAffairsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.time.Period;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class PersonAffairsServiceImpl implements PersonAffairsService {


    @Autowired
    private PersonAffairsMapper personAffairsMapper;

    @Override
    public void visaDealA(int departmentAAudit, String username) throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("departmentAAduit", departmentAAudit);
        map.put("username", username);
        personAffairsMapper.visaDealA(map);

    }

    @Override
    public void visaDealB(int departmentBAudit, String username) throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("departmentBAduit", departmentBAudit);
        map.put("username", username);
        personAffairsMapper.visaDealB(map);

    }

    @Override
    public List<PersonAffairs> findAllPersonAffairs(int page, int limit) throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("page", (page - 1) * limit);
        map.put("limit", limit);
        return personAffairsMapper.findAllPersonAffairs(map);
    }

    @Override
    public int findAllPersonAffairsCount() throws Exception {
        return personAffairsMapper.findAllPersonAffairsCount();
    }

    @Override
    public String agreeUserServiceA(HttpSession session, int id) throws Exception {
        String department = (String) session.getAttribute("department");
        int grade = (int) session.getAttribute("grade");
        if (department.equals("A")) {
            if (grade >= 2) {
                personAffairsMapper.agreeUserServiceA(id);
                return "处理成功";
            } else {
                return "你的等级不够";
            }
        } else {
            return "本部门业务你无权限处理";
        }
    }

    @Override
    public String agreeUserServiceB(HttpSession session, int id) throws Exception {
        String department = (String) session.getAttribute("department");
        int grade = (int) session.getAttribute("grade");
        if (department.equals("B")) {
            if (grade >= 5) {
                personAffairsMapper.agreeUserServiceB(id);
                return "处理成功";
            } else {
                return "你的等级不够";
            }
        } else {
            return "本部门业务你无权限处理";
        }
    }

    @Override
    public List<PersonAffairs> findUnDealpersonAffairs(String section) throws Exception {
        if (section.equals("A")){
            return (personAffairsMapper.DepartmentAfindUnDealpersonAffairs());
        }else{
            return (personAffairsMapper.DepartmentBfindUnDealpersonAffairs());
        }
    }

}
