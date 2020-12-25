package com.globaltech.aspire.service;

import com.globaltech.aspire.dto.TagsDTO;
import com.globaltech.aspire.entity.QuestionTags;
import com.globaltech.aspire.entity.Tags;

import java.util.List;

public interface TagsService {

    TagsDTO createTags(Tags tags, QuestionTags questionTags) throws Exception;

    List<Tags> query(QuestionTags questionTags);
}
