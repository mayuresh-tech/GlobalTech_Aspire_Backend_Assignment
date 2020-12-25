package com.globaltech.aspire.dto;

import com.globaltech.aspire.entity.Tags;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class QuestionTagsDTO {

    private String questionTagId;

    private String questionId;

    private List<Tags> tagsList;

}
