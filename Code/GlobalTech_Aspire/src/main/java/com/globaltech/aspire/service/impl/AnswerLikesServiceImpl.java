package com.globaltech.aspire.service.impl;

import com.globaltech.aspire.dto.ResponseDTO;
import com.globaltech.aspire.entity.Answer;
import com.globaltech.aspire.entity.AnswerLikes;
import com.globaltech.aspire.repository.AnswerLikesRepository;
import com.globaltech.aspire.service.AnswerLikesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class AnswerLikesServiceImpl implements AnswerLikesService {

    @Autowired
    AnswerLikesRepository answerLikesRepository;


    @Override
    public boolean saveLikeForAnswer(String answerId, String userId) throws Exception {
        if (answerLikesRepository.findByAnswerIdAndUserId(answerId, userId) == null) {
            AnswerLikes answerLikes = new AnswerLikes();
            answerLikes.setCreatedAt(new Date());
            answerLikes.setUpdatedAt(new Date());
            answerLikes.setId(UUID.randomUUID().toString());
            answerLikes.setAnswerId(answerId);
            answerLikes.setUserId(userId);

            answerLikesRepository.save(answerLikes);
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public boolean checkAnswerLike(String answerId, String userId) {
        if (answerLikesRepository.findByAnswerIdAndUserId(answerId, userId) == null) {
            return false;
        }
        else {
            return true;
        }
    }

    @Override
    public List<AnswerLikes> query(String answerId) {
        return answerLikesRepository.queryBy(answerId);
    }
}
