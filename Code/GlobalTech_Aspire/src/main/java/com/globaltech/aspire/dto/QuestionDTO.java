package com.globaltech.aspire.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuestionDTO {

    private String questionId;

    private String questionTitle;

    private String questionDescription;

    private String companyAsked;

    private String companyId;

    private String userId;

}
