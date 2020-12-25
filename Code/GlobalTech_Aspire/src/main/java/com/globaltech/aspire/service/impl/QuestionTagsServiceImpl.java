package com.globaltech.aspire.service.impl;

import com.globaltech.aspire.dto.QuestionTagsDTO;
import com.globaltech.aspire.dto.QuestionTopicDTO;
import com.globaltech.aspire.entity.Question;
import com.globaltech.aspire.entity.QuestionTags;
import com.globaltech.aspire.repository.QuestionTagsRepository;
import com.globaltech.aspire.service.QuestionTagsService;
import com.globaltech.aspire.util.EntityDTOConverter;
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
public class QuestionTagsServiceImpl implements QuestionTagsService {

    @Autowired
    QuestionTagsRepository questionTagsRepository;

    @Override
    public QuestionTags createQuestionTags(QuestionTags questionTags, Question question) throws Exception {
        try {
            questionTags.setCreatedAt(new Date());
            questionTags.setUpdatedAt(new Date());
            questionTags.setQuestionTagId(UUID.randomUUID().toString());
            questionTags.setQId(question);
            questionTagsRepository.save(questionTags);

            questionTags.setQuestionTagId(questionTags.getQuestionTagId());
            return questionTags;
        }
        catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ErrorMessages.ERROR_OCCURRED);
        }
    }

    @Override
    public List<QuestionTags> query(Question question) {
        return questionTagsRepository.queryBy(question);
    }

}
