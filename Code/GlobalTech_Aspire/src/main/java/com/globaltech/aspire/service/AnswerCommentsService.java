package com.globaltech.aspire.service;

import com.globaltech.aspire.entity.Answer;
import com.globaltech.aspire.entity.AnswerComments;

import java.util.List;

public interface AnswerCommentsService {

    String saveAnswerComment(String answerId, String userId, String comment) throws Exception;

    List<AnswerComments> query(Answer answer);
}
