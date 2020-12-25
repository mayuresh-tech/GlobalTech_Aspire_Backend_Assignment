package com.globaltech.aspire.controller;

import com.globaltech.aspire.dto.QuestionDTO;
import com.globaltech.aspire.dto.ResponseDTO;
import com.globaltech.aspire.entity.*;
import com.globaltech.aspire.service.QuestionService;
import com.globaltech.aspire.util.ErrorMessages;
import io.swagger.annotations.ApiOperation;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.constraints.Min;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/question")
@Validated
public class QuestionController extends BaseController {

    @Autowired
    QuestionService questionService;

    @ApiOperation(value = "Create new Question")
    @PostMapping(path = "/saveNewQuestion", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseDTO saveQuestion(@RequestParam(required = false) String questionTitle, @RequestParam @Length(min = 50, max = 500) String questionDescription, @RequestParam String userId, @RequestParam(required = false) String companyAsked, @RequestParam(required = false) String companyId, @RequestParam String topicName, @RequestParam String subTopic, @RequestParam(required = false) String tagsList) throws Exception {

        Question question = new Question();

        QuestionDTO questionDTO = new QuestionDTO();

        QuestionTopic questionTopic = new QuestionTopic();

        Tags tags = new Tags();

        QuestionTags questionTags = new QuestionTags();

        question.setQuestionTitle(questionTitle);
        question.setQuestionDescription(questionDescription);
        question.setUserId(userId);
        question.setCompanyId(companyId);
        question.setCompanyAsked(companyAsked);

        questionDTO.setQuestionTitle(questionTitle);
        questionDTO.setQuestionDescription(questionDescription);
        questionDTO.setUserId(userId);
        questionDTO.setCompanyId(companyId);
        questionDTO.setCompanyAsked(companyAsked);

        questionTopic.setCreatedAt(new Date());
        questionTopic.setQId(question);
        questionTopic.setTopicName(topicName);
        questionTopic.setSubTopic(subTopic);

        tags.setCreatedAt(new Date());
        tags.setQTId(questionTags);
        tags.setTags(tagsList);

        questionTags.setQId(question);
        questionTags.setCreatedAt(new Date());
        List<Tags> tagsList1 = new ArrayList<>();
        tagsList1.add(tags);

        String result = questionService.saveQuestion(questionDTO,  new Answer(), questionTopic, questionTags, tags);
        if (!result.equals("Error")) {
            return new ResponseDTO(200, result, "Done");
        }
        else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ErrorMessages.ERROR_OCCURRED);
        }
    }
}
