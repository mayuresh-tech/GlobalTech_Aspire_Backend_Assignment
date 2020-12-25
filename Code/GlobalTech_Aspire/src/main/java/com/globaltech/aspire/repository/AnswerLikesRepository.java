package com.globaltech.aspire.repository;

import com.globaltech.aspire.entity.Answer;
import com.globaltech.aspire.entity.AnswerLikes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswerLikesRepository extends JpaRepository<AnswerLikes, String> {

    AnswerLikes findByAnswerIdAndUserId(String answerId, String userId);

    @Query(value = "SELECT al from AnswerLikes al where " +
            "al.answerId=:ans_id")
    List<AnswerLikes> queryBy(@Param("ans_id") String answerId);

}