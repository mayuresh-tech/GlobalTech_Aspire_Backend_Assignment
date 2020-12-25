package com.globaltech.aspire.dto;

import com.globaltech.aspire.entity.Question;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AnswerDTO {

    public AnswerDTO() {

    }

    public AnswerDTO(String answerId, Question qId, String answerDescription, String answeredById) {
        this.answerId = answerId;
        this.qId = qId;
        this.answerDescription = answerDescription;
        this.answeredById =answeredById;
    }

    private String answerId;

    private Question qId;

    private String answerDescription;

    private String answeredById;

}
