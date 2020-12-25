package com.globaltech.aspire.service;

import com.globaltech.aspire.entity.AnswerLikes;

import java.util.List;

public interface AnswerLikesService {

    boolean saveLikeForAnswer(String answerId, String userId) throws Exception;

    boolean checkAnswerLike(String answerId, String userId);

    List<AnswerLikes> query(String answerId);

}
