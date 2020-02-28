package com.service;

import com.entity.CorperateAffairs;

import java.util.List;

public interface CorperateAffairsService {
    void sectionA(int sectionA, String legalPerson) throws Exception;

    void sectionB(int sectionB, String legalPerson) throws Exception;

    List<CorperateAffairs> findAllCorperateAffairs() throws Exception;
}
