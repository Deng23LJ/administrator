package com.controller;


import com.entity.Chat;
import com.entity.Complaint;
import com.entity.Suggestion;
import com.service.GovernmentAndPeopleCommunicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class GovernmentAndPeopleCommunicationController {

    @Autowired
    private GovernmentAndPeopleCommunicationService governmentAndPeopleCommunicationService;

    //咨询服务:1.消息展示 2.聊天
    @PostMapping("counselMessageDisp.do")
    public List<Chat> counselMessageDisp(HttpSession session) throws Exception {
        List<Chat> chatRecordList = governmentAndPeopleCommunicationService.findAllChatRecord();
        return chatRecordList;

    }


    //2.进行聊天
    @PostMapping("chatting.do")
    public void chatting(HttpSession session, String send, String chatContent) throws Exception {
        String receive = (String) session.getAttribute("name");
        governmentAndPeopleCommunicationService.chatting(receive, send, chatContent);
    }

    //投诉信息
    @GetMapping("complaint.do")
    public Map<String,Object> showComplaint(int page,int limit) throws Exception {
        List<Complaint> complaintsList = governmentAndPeopleCommunicationService.findAllComplaint(page,limit);
        int count = governmentAndPeopleCommunicationService.findAllComplaintCount();
        Map<String,Object> map=new HashMap<>();		//装填回调数据
        map.put("code", 0);
        map.put("msg", "个人事务");
        map.put("count", count);   //获得数据的总数
        map.put("data",complaintsList);    //本次分页查询的数据
        return map;
    }

    //建议展示
    @GetMapping("suggestion.do")
    public Map<String,Object> findAllSuggestion(int page,int limit) throws Exception {
        List<Suggestion> suggestionsList = governmentAndPeopleCommunicationService.findAllSuggestion(page,limit);
        int count = governmentAndPeopleCommunicationService.findAllSuggestionCount();
        Map<String,Object> map=new HashMap<>();		//装填回调数据
        map.put("code", 0);
        map.put("msg", "个人事务");
        map.put("count", count);   //获得数据的总数
        map.put("data",suggestionsList);    //本次分页查询的数据
        return map;
    }

}
