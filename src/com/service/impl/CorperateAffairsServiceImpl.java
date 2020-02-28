package com.service.impl;

import com.entity.CorperateAffairs;
import com.mapper.CorperateAffairsMapper;
import com.service.CorperateAffairsService;
import org.omg.PortableInterceptor.ObjectReferenceFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class CorperateAffairsServiceImpl implements CorperateAffairsService {
    @Autowired
    private CorperateAffairsMapper corperateAffairsMapper;
    @Override
    public void sectionA(int sectionA, String legalPerson) throws Exception {
        Map<String,Object> map = new HashMap<>();
        map.put("sectionA",sectionA);
        map.put("legalPerson",legalPerson);
        corperateAffairsMapper.sectionA(map);
    }

    @Override
    public void sectionB(int sectionB, String legalPerson) throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("sectionB",sectionB);
        map.put("legalPerson",legalPerson);
        corperateAffairsMapper.sectionB(map);
    }

    @Override
    public List<CorperateAffairs> findAllCorperateAffairs() throws Exception {
        return corperateAffairsMapper.findAllCorperateAffairs();
    }
}
