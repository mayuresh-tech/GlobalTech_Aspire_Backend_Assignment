package com.globaltech.aspire.service;

import com.globaltech.aspire.entity.Question;
import com.globaltech.aspire.entity.QuestionTags;

import java.util.List;

public interface QuestionTagsService {

    QuestionTags createQuestionTags(QuestionTags questionTags, Question question) throws Exception;

    List<QuestionTags> query(Question question);
}
