package com.service.impl;

import com.entity.JsonResult;
import com.entity.News;
import com.mapper.NewsManageMapper;
import com.service.NewsManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class NewsManageServiceImpl implements NewsManageService {

    @Autowired
    private NewsManageMapper newsManageMapper;


    @Override
    public JsonResult newsUp(News news) throws Exception {
        try{
            newsManageMapper.newsUp(news);
            return new JsonResult(true,"上架成功");
        }catch (Exception e){
            e.printStackTrace();
        }
        return new JsonResult(false,"上架异常");
    }

    @Override
    public List<News> newsShow(int page,int limit) throws Exception {
        Map<String ,Object> map = new HashMap<>();
        map.put("page",(page-1)*limit);
        map.put("limit",limit);
        return newsManageMapper.newsShow(map);
    }

    @Override
    public int newsCount() throws Exception {
        return newsManageMapper.newsCount();
    }
}
