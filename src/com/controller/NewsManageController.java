package com.controller;


import com.entity.JsonResult;
import com.entity.News;
import com.service.NewsManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class NewsManageController {

    @Autowired
    private NewsManageService newsManageService;


    //新闻展示
    @RequestMapping("newsShow.do")
    public Map<String, Object> newsShow(int page, int limit) throws Exception{
        List<News> newsList = newsManageService.newsShow(page,limit);
        int count = newsManageService.newsCount();
        Map<String,Object> map=new HashMap<>();		//装填回调数据
        map.put("code", 0);
        map.put("msg", "随便写啥");
        map.put("count", count);//获得数据的总数
        map.put("data", newsList);//本次分页查询的数据
        return map;
    }

    //新闻上架
    @PostMapping("newsUp.do")
    public int newsUp(News news) throws Exception{
        JsonResult feedback = newsManageService.newsUp(news);
        System.out.println(feedback);
        if (feedback.isSuccess()){
            return 1;
        }else{
            return 0;
        }
    }
}
