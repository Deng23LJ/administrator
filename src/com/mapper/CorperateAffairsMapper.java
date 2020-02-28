package com.mapper;

import com.entity.CorperateAffairs;

import java.util.List;
import java.util.Map;

public interface CorperateAffairsMapper {
    void sectionA(Map<String, Object> map) throws Exception;

    void sectionB(Map<String, Object> map) throws Exception;

    List<CorperateAffairs> findAllCorperateAffairs() throws Exception;
}
