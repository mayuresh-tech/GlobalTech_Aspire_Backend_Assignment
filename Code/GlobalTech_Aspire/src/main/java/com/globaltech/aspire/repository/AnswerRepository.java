package com.globaltech.aspire.repository;

import com.globaltech.aspire.entity.Answer;
import com.globaltech.aspire.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, String> {

    Answer findByAnswerId(String answerId);

    @Query(value = "SELECT a from Answer a where " +
            "a.qId=:question_id")
    List<Answer> queryBy(@Param("question_id") Question question);
}

//qId=:question_id