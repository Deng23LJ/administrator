package com.mapper;

import com.entity.Chat;
import com.entity.Complaint;
import com.entity.Suggestion;

import java.util.List;
import java.util.Map;

public interface GovernmentAndPeopleCommunicationMapper {
    List<Chat> findAllChatRecord() throws Exception;

    void chatting(Map<String,Object> map) throws Exception;

    List<Complaint> findAllComplaint(Map<String,Object> map ) throws Exception;

    List<Suggestion> findAllSuggestion(Map<String,Object> map ) throws Exception;

    int findAllComplaintCount() throws Exception;

    int findAllSuggestionCount() throws Exception;
}
