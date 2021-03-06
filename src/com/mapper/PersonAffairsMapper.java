package com.mapper;

import com.entity.PersonAffairs;

import java.util.List;
import java.util.Map;

public interface PersonAffairsMapper {

    void visaDealA(Map<String, Object> map) throws Exception;

    void visaDealB(Map<String, Object> map) throws Exception;


    List<PersonAffairs> findAllPersonAffairs(Map<String, Object> map) throws Exception;

    int findAllPersonAffairsCount() throws Exception;


    List<PersonAffairs> DepartmentAfindUnDealpersonAffairs() throws Exception;

    void agreeUserServiceA(int id) throws Exception;

    List<PersonAffairs> DepartmentBfindUnDealpersonAffairs() throws Exception;

    void agreeUserServiceB(int id) throws Exception;

}