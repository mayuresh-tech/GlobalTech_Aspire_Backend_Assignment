package com.globaltech.aspire.service.impl;

import com.globaltech.aspire.dto.CompanyDTO;
import com.globaltech.aspire.dto.QuestionDTO;
import com.globaltech.aspire.entity.*;
import com.globaltech.aspire.repository.QuestionRepository;
import com.globaltech.aspire.service.*;
import com.globaltech.aspire.util.ErrorMessages;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@Service
@Slf4j
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    QuestionRepository questionRepository;

    @Autowired
    QuestionTagsService questionTagsService;

    @Autowired
    TagsService tagsService;

    @Autowired
    CompanyService companyService;

    @Autowired
    QuestionTopicService questionTopicService;

    @Override
    public String saveQuestion(QuestionDTO questionDTO, @RequestParam(required = false) Answer answer, QuestionTopic questionTopic, QuestionTags questionTags, Tags tags) throws Exception {

        try {
            Question question = new Question();
            question.setCreatedAt(new Date());
            question.setUpdatedAt(new Date());
            question.setQuestionId(UUID.randomUUID().toString());
            question.setQuestionTitle(questionDTO.getQuestionTitle());
            question.setQuestionDescription(questionDTO.getQuestionDescription());

            if (questionDTO.getCompanyAsked() == null && questionDTO.getCompanyId() != null || questionDTO.getCompanyAsked().isEmpty() && !questionDTO.getCompanyId().isEmpty()) {
                Company company = companyService.getCompanyDetails(questionDTO.getCompanyId());
                questionDTO.setCompanyAsked(company.getCompanyName());
            }
            else if (questionDTO.getQuestionId() == null && questionDTO.getCompanyAsked() != null || !questionDTO.getCompanyAsked().isEmpty() && questionDTO.getCompanyId().isEmpty()) {
                CompanyDTO company = companyService.checkCompany(questionDTO.getCompanyAsked());
                questionDTO.setCompanyId(company.getCompanyId());
            }
            question.setCompanyAsked(questionDTO.getCompanyAsked());
            question.setCompanyId(questionDTO.getCompanyId());
            question.setUserId(questionDTO.getUserId());

            questionRepository.save(question);
            questionTagsService.createQuestionTags(questionTags, question);
            tagsService.createTags(tags, questionTags);
            questionTopicService.createTopicForQuestion(questionTopic, question);

            if (questionRepository.findByQuestionId(question.getQuestionId()) != null) {
                return question.getQuestionId();
            }
            else {
                return "Error";
            }
        }
        catch (Exception e) {
            System.out.println(e.toString());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ErrorMessages.ERROR_OCCURRED);
        }
    }

    @Override
    public Question getQuestion(String questionId) {
        return questionRepository.findByQuestionId(questionId);
    }

    @Override
    public List<Question> findQuestionsByCompanyId(List<String> companyIds) {
        return questionRepository.findQuestionsByCId(companyIds);
    }


}
