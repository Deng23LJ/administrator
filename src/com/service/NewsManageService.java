package com.service;

import com.entity.JsonResult;
import com.entity.News;

import java.util.List;

public interface NewsManageService {

    JsonResult newsUp(News news) throws Exception;

    List<News> newsShow(int page, int limit) throws Exception;

    int newsCount() throws Exception;
}
