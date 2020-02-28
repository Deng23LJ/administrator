package com.service;

import com.entity.PersonAffairs;

import java.util.List;

public interface PersonAffairsService {

    void visaDealA(int departmentAAudit,String username) throws Exception ;

    void visaDealB(int departmentBAudit, String username) throws Exception;

    List<PersonAffairs> findAllPersonAffairs(int page,int limit) throws Exception;

    int findAllPersonAffairsCount() throws Exception;
}