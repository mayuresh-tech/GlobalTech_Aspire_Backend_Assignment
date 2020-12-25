package com.globaltech.aspire.repository;

import com.globaltech.aspire.entity.QuestionLikes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionLikesRespository extends JpaRepository<QuestionLikes, String> {

    QuestionLikes findByQuestionIdAndUserId(String questionId, String userId);

    @Query(value = "SELECT ql from QuestionLikes ql where " +
            "ql.questionId=:question_id")
    List<QuestionLikes> queryBy(@Param("question_id") String questionId);

    @Query(value = "SELECT ql.questionId from QuestionLikes ql where " +
            "ql.questionId in (:question_id)")
    List<String> findCountOfLikes(@Param("question_id") List<String> questionId);
}
