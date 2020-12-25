package com.globaltech.aspire.dto;

import com.globaltech.aspire.entity.*;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;

@Getter
@Setter
public class CustomDetailsDTO {

    Question question;

    List<Answer> answerList;

    List<List<AnswerComments>> ansCommentList;

    List<List<AnswerLikes>> answerLikesList;

    List<QuestionLikes> questionLikesList;

    Company company;

    List<List<Tags>> tagsList;

    List<QuestionTopic> questionTopicList;

    public CustomDetailsDTO() {

    }


    public CustomDetailsDTO(Question question, List<Answer> answerList, List<List<AnswerComments>> ansCommentList, List<List<AnswerLikes>> ansLikesList, List<QuestionLikes> questionLikesList, Company company, List<List<Tags>> tagsList, List<QuestionTopic> questionTopicList) {
        this.question = question;
        this.answerList = answerList;
        this.ansCommentList = ansCommentList;
        this.answerLikesList = ansLikesList;
        this.questionLikesList = questionLikesList;
        this.company = company;
        this.tagsList = tagsList;
        this.questionTopicList = questionTopicList;
    }

}
