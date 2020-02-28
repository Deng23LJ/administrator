package com.mapper;

import com.entity.News;

import java.util.List;
import java.util.Map;

public interface NewsManageMapper {
    void newsUp(News news) throws Exception;

    List<News> newsShow(Map<String ,Object> map) throws Exception;

    int newsCount() throws Exception;
}
