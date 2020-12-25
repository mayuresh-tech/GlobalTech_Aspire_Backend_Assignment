package com.globaltech.aspire.dto;

import com.globaltech.aspire.entity.Answer;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AnswerCommentsDTO {

    public AnswerCommentsDTO() {

    }

    public AnswerCommentsDTO(String commentId, String comment, String userId, Answer ansId) {
        this.commentId = commentId;
        this.comment = comment;
        this.userId = userId;
        this.ansId =ansId;
    }

    private String commentId;

    private String comment;

    private String userId;

    private Answer ansId;

}
