package com.globaltech.aspire.service;

import com.globaltech.aspire.entity.Question;
import com.globaltech.aspire.entity.QuestionTopic;

import java.util.List;

public interface QuestionTopicService {

    QuestionTopic createTopicForQuestion(QuestionTopic questionTopic, Question question) throws Exception;

    List<QuestionTopic> query(Question question);

    List<QuestionTopic> findBySubTopics(List<String> subTopcis, List<Question> questions);
}
