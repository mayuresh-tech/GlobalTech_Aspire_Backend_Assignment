package com.globaltech.aspire.controller;

import com.globaltech.aspire.entity.*;
import com.globaltech.aspire.service.*;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/filterAndGetQuestion")
@Validated
public class FilterQuestionParamController {

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

    Map<String, Integer> hm = new HashMap<String, Integer>();

    @ApiOperation(value = "Get filtered list of Questions based upon Parameters")
    @GetMapping(path = "/getFilter", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Question> getQuestionFromFilter(@RequestParam(required = false) List<String> companyList, @RequestParam(required = false) List<String> subTopics, @RequestParam(required = false) int questionLikes, @RequestParam(required = false) @DateTimeFormat(pattern = "dd.MM.yyyy") Date date, @RequestParam(required = false) List<String> tagsList) {

        List<Question> questionListFromDB = new ArrayList<>();
        List<String> questionIds = new ArrayList<>();
        List<QuestionTopic> questionTopicListFromDB = new ArrayList<>();
        List<QuestionTags> questionTagsListFromDB = new ArrayList<>();

        hm.clear();
        questionListFromDB.clear();
        questionIds.clear();
        questionTopicListFromDB.clear();
        questionTagsListFromDB.clear();

        if (companyList != null) {
            List<Company> companyListFromDB = companyService.findByCompanyName(companyList);

            List<String> companyIds = new ArrayList<>();

            for (Company c: companyListFromDB) {
                companyIds.add(c.getCompanyId());
            }

            questionListFromDB = questionService.findQuestionsByCompanyId(companyIds);

            if (subTopics != null) {
                questionTopicListFromDB = questionTopicService.findBySubTopics(subTopics, questionListFromDB);

                if (questionTopicListFromDB != null) {
                    questionListFromDB.clear();

                    for (QuestionTopic qt: questionTopicListFromDB) {
                        questionListFromDB.add(qt.getQId());
                    }
                }

                if (questionLikes != 0) {
                    for (Question q: questionListFromDB) {
                        questionIds.add(q.getQuestionId());
                    }

                    countFrequencies(questionLikesService.findLikes(questionIds));

                    hm.entrySet()
                            .removeIf(
                                    entry -> (questionLikes > entry.getValue()));

                    questionIds.clear();
                    questionListFromDB.clear();

                    for (Map.Entry<String, Integer> entry: hm.entrySet()) {
                        questionIds.add(entry.getKey());
                    }

                    for (String i: questionIds) {
                        questionListFromDB.add(questionService.getQuestion(i));
                    }

                    questionIds.clear();

                    if (date != null) {
                        for (Question q : questionListFromDB) {
                            if (q.getCreatedAt().after(date)) {
                                questionIds.add(q.getQuestionId());
                            }
                        }

                        questionListFromDB.clear();

                        for (String i: questionIds) {
                            questionListFromDB.add(questionService.getQuestion(i));
                        }

                        questionIds.clear();
                        
                        if (tagsList != null) {
                            List<List<QuestionTags>> questionTagsList = new ArrayList<>();

                            for (Question q: questionListFromDB) {
                                questionTagsList.add(questionTagsService.query(q));
                            }

                            List<List<Tags>> tagsListFromDB = new ArrayList<>();

                            for (List<QuestionTags> qtList : questionTagsList) {
                                for (QuestionTags qt: qtList) {
                                    tagsListFromDB.add(tagsService.query(qt));
                                }
                            }

                            for (List<Tags> tlist: tagsListFromDB) {
                                for (Tags t : tlist) {
                                    String check = t.getTags();
                                    
                                    List<String> tagsCheck = Arrays.asList(check.split(","));

                                    for (String i: tagsCheck) {
                                        if (tagsList.contains(i)) {
                                            questionTagsListFromDB.add(t.getQTId());
                                        }
                                    }
                                }
                            }

                            questionListFromDB.clear();

                            for (QuestionTags qt: questionTagsListFromDB) {
                                questionListFromDB.add(qt.getQId());
                            }

                            System.out.println("Here: " + questionListFromDB);
                            return questionListFromDB;
                        }
                    }
                }
                /*** To further implement (Optimization needed) ***/
                else {

                }
            }
            else {

            }
        }
        else {

        }
        return questionListFromDB;
    }

    void countFrequencies(List<String> list)
    {
        for (String i : list) {
            Integer j = hm.get(i);
            hm.put(i, (j == null) ? 1 : j + 1);
        }
    }
}
