package com.globaltech.aspire.service;


import com.globaltech.aspire.entity.QuestionLikes;

import java.util.List;

public interface QuestionLikesService {

    boolean saveLikeForQuestion(String questionId, String userId) throws Exception;

    boolean checkQuestionLike(String questionId, String userId);

    List<QuestionLikes> query(String questionId);

    List<String> findLikes(List<String> questionIds);
}
