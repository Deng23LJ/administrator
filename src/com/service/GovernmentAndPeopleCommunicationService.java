package com.service;

import com.entity.Chat;
import com.entity.Complaint;
import com.entity.Suggestion;

import java.util.List;

public interface GovernmentAndPeopleCommunicationService {
    List<Chat> findAllChatRecord() throws Exception;

    void chatting(String receive, String send, String chatContent) throws Exception;

    List<Complaint> findAllComplaint(int page,int limit) throws Exception;

    List<Suggestion> findAllSuggestion(int page,int limit) throws Exception;

    int findAllComplaintCount() throws Exception;

    int findAllSuggestionCount() throws Exception;

}
