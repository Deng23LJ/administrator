package com.service.impl;

import com.entity.Chat;
import com.entity.Complaint;
import com.entity.Suggestion;
import com.mapper.GovernmentAndPeopleCommunicationMapper;
import com.service.GovernmentAndPeopleCommunicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class GovernmentAndPeopleCommunicationServiceImpl implements GovernmentAndPeopleCommunicationService {
    @Autowired
    private GovernmentAndPeopleCommunicationMapper governmentAndPeopleCommunicationMapper;


    @Override
    public List<Chat> findAllChatRecord() throws Exception {
        return governmentAndPeopleCommunicationMapper.findAllChatRecord();
    }

    @Override
    public void chatting(String receive, String send, String chatContent) throws Exception {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String time = simpleDateFormat.format(new Date());
//        System.out.println(time);
        Map<String,Object> map = new HashMap<>();
        map.put("time",time);
        map.put("send",send);
        map.put("receive",receive);
        map.put("chatContent",chatContent);
        governmentAndPeopleCommunicationMapper.chatting(map);

    }

    @Override
    public List<Complaint> findAllComplaint(int page,int limit) throws Exception {
        Map<String,Object> map = new HashMap<>();
        map.put("page",(page-1)*limit);
        map.put("limit",limit);
        return governmentAndPeopleCommunicationMapper.findAllComplaint(map);
    }

    @Override
    public List<Suggestion> findAllSuggestion(int page,int limit) throws Exception {
        Map<String,Object> map = new HashMap<>();
        map.put("page",(page-1)*limit);
        map.put("limit",limit);
        return governmentAndPeopleCommunicationMapper.findAllSuggestion(map);
    }

    @Override
    public int findAllComplaintCount() throws Exception {
        return governmentAndPeopleCommunicationMapper.findAllComplaintCount();
    }

    @Override
    public int findAllSuggestionCount() throws Exception {
        return governmentAndPeopleCommunicationMapper.findAllSuggestionCount();
    }
}
