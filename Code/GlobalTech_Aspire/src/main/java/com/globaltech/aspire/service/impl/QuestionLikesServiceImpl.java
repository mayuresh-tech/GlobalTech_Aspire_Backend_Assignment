package com.globaltech.aspire.service.impl;

import com.globaltech.aspire.entity.QuestionLikes;
import com.globaltech.aspire.repository.QuestionLikesRespository;
import com.globaltech.aspire.service.QuestionLikesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class QuestionLikesServiceImpl implements QuestionLikesService {

    @Autowired
    QuestionLikesRespository questionLikesRespository;

    @Override
    public boolean saveLikeForQuestion(String questionId, String userId) throws Exception {
        if (questionLikesRespository.findByQuestionIdAndUserId(questionId, userId) == null) {
            QuestionLikes questionLikes = new QuestionLikes();
            questionLikes.setCreatedAt(new Date());
            questionLikes.setUpdatedAt(new Date());
            questionLikes.setId(UUID.randomUUID().toString());
            questionLikes.setQuestionId(questionId);
            questionLikes.setUserId(userId);

            questionLikesRespository.save(questionLikes);
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public boolean checkQuestionLike(String questionId, String userId) {
        if (questionLikesRespository.findByQuestionIdAndUserId(questionId, userId) == null) {
            return false;
        }
        else {
            return true;
        }
    }

    @Override
    public List<QuestionLikes> query(String questionId) {
        return questionLikesRespository.queryBy(questionId);
    }

    @Override
    public List<String> findLikes(List<String> questionIds) {
        return questionLikesRespository.findCountOfLikes(questionIds);
    }
}