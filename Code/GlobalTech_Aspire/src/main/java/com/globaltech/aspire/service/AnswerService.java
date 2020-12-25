package com.globaltech.aspire.service;

import com.globaltech.aspire.entity.Answer;
import com.globaltech.aspire.entity.Question;

import java.util.List;

public interface AnswerService {

    String saveAnswer(Answer answer, String questionId) throws Exception;

    List<Answer> query(Question questionId);

}
