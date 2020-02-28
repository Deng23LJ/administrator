package com.service.impl;

import com.entity.PersonAffairs;
import com.mapper.PersonAffairsMapper;
import com.service.PersonAffairsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        Map<String,Object> map = new HashMap<>();
        map.put("departmentAAduit",departmentAAudit);
        map.put("username",username);
        personAffairsMapper.visaDealA(map);

    }
    @Override
    public void visaDealB(int departmentBAudit, String username) throws Exception {
        Map<String,Object> map = new HashMap<>();
        map.put("departmentBAduit",departmentBAudit);
        map.put("username",username);
        personAffairsMapper.visaDealB(map);

    }

    @Override
    public List<PersonAffairs> findAllPersonAffairs(int page,int limit) throws Exception {
        Map<String,Object> map = new HashMap<>();
        map.put("page",(page-1)*limit);
        map.put("limit",limit);
        return personAffairsMapper.findAllPersonAffairs(map);
    }

    @Override
    public int findAllPersonAffairsCount() throws Exception {
        return personAffairsMapper.findAllPersonAffairsCount();
    }
}
