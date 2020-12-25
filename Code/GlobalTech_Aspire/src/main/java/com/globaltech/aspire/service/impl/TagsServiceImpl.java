package com.globaltech.aspire.service.impl;

import com.globaltech.aspire.dto.TagsDTO;
import com.globaltech.aspire.entity.QuestionTags;
import com.globaltech.aspire.entity.Tags;
import com.globaltech.aspire.repository.TagsRepository;
import com.globaltech.aspire.service.TagsService;
import com.globaltech.aspire.util.EntityDTOConverter;
import com.globaltech.aspire.util.ErrorMessages;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@Service
@Slf4j
public class TagsServiceImpl implements TagsService {

    @Autowired
    TagsRepository tagsRepository;

    @Override
    public TagsDTO createTags(Tags tags, QuestionTags questionTags) throws Exception {
        try {
            tags.setCreatedAt(new Date());
            tags.setUpdatedAt(new Date());
            tags.setTagId(UUID.randomUUID().toString());
            tags.setQTId(questionTags);

            List<String> list = Arrays.asList(tags.getTags().split(","));
            Queue<String> arrayLifoQueue = new ArrayDeque<>(list);

            String tagsList = String.join(",", arrayLifoQueue);
            tags.setTags(tagsList);

            tagsRepository.save(tags);

            return EntityDTOConverter.getTagsDTOFromEntity(tags);
        }
        catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ErrorMessages.ERROR_OCCURRED);
        }
    }

    @Override
    public List<Tags> query(QuestionTags questionTags) {
        return tagsRepository.queryBy(questionTags);
    }
}
