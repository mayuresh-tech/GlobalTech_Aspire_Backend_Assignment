package com.globaltech.aspire.controller;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.globaltech.aspire.dto.CustomDetailsDTO;
import com.globaltech.aspire.entity.*;
import com.globaltech.aspire.service.*;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/questionDetails")
@Validated
@JsonIgnoreProperties(ignoreUnknown = true)
public class QuestionDetailsController extends BaseController {

    @Autowired
    QuestionService questionService;

    @Autowired
    AnswerService answerService;

    @Autowired
    AnswerCommentsService answerCommentsService;

    @Autowired
    AnswerLikesService answerLikesService;

    @Autowired
    QuestionLikesService questionLikesService;

    @Autowired
    CompanyService companyService;

    @Autowired
    TagsService tagsService;

    @Autowired
    QuestionTagsService questionTagsService;

    @Autowired
    QuestionTopicService questionTopicService;

    @Autowired
    QuestionCompanyMappingService questionCompanyMappingService;

    @ApiOperation(value = "Get details of a Question")
    @GetMapping(path = "/getQuestionDetails", produces = {MediaType.APPLICATION_JSON_VALUE})
    public CustomDetailsDTO getDetails(@RequestParam String questionId) {

        Question question = questionService.getQuestion(questionId);

        List<QuestionLikes> questionLikesList = questionLikesService.query(question.getQuestionId());

        //List<QuestionCompanyMapping> questionCompanyMappingList = questionCompanyMappingService.query(question);

        List<QuestionTags> questionTagsList = questionTagsService.query(question);

        List<List<Tags>> tagsList = new ArrayList<>();
        for (QuestionTags q : questionTagsList) {
            tagsList.add(tagsService.query(q));
        }

        List<QuestionTopic> questionTopicList = questionTopicService.query(question);

        Company companyDetails = companyService.getCompanyDetails(question.getCompanyId());

        List<Answer> answerList = answerService.query(question);

        List<List<AnswerLikes>> ansLikesList = new ArrayList<>();
        for (Answer a : answerList) {
            ansLikesList.add(answerLikesService.query(a.getAnswerId()));
        }

        List<List<AnswerComments>> answerCommentsList = new ArrayList<>();
        for (Answer a : answerList) {
            answerCommentsList.add(answerCommentsService.query(a));
        }

        return new CustomDetailsDTO(question, answerList, answerCommentsList, ansLikesList, questionLikesList, companyDetails, tagsList, questionTopicList);
    }

}
