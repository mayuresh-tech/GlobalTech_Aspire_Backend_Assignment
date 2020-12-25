package com.globaltech.aspire.service.impl;

import com.globaltech.aspire.dto.QuestionTopicDTO;
import com.globaltech.aspire.entity.Question;
import com.globaltech.aspire.entity.QuestionTopic;
import com.globaltech.aspire.repository.QuestionTopicRepository;
import com.globaltech.aspire.service.QuestionTopicService;
import com.globaltech.aspire.util.ErrorMessages;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class QuestionTopicServiceImpl implements QuestionTopicService {

    @Autowired
    QuestionTopicRepository questionTopicRepository;

    @Override
    public QuestionTopic createTopicForQuestion(QuestionTopic questionTopic, Question question) throws Exception {
        try {
            questionTopic.setTopicId(UUID.randomUUID().toString());
            questionTopic.setQId(question);
            questionTopic.setCreatedAt(new Date());
            questionTopic.setUpdatedAt(new Date());

            questionTopicRepository.save(questionTopic);

            return questionTopic;
        }
        catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ErrorMessages.ERROR_OCCURRED);
        }
    }

    @Override
    public List<QuestionTopic> query(Question question) {
        return questionTopicRepository.queryBy(question);
    }

    @Override
    public List<QuestionTopic> findBySubTopics(List<String> subTopics, List<Question> questions) {
        return questionTopicRepository.findBySubTopics(subTopics, questions);
    }

}
