package com.globaltech.aspire.service;

import com.globaltech.aspire.dto.QuestionDTO;
import com.globaltech.aspire.entity.*;

import java.util.List;

public interface QuestionService {

    String saveQuestion(QuestionDTO questionDTO, Answer answer, QuestionTopic questionTopic, QuestionTags questionTags, Tags tags) throws Exception;

    Question getQuestion(String questionId);

    List<Question> findQuestionsByCompanyId(List<String> companyIds);
}
