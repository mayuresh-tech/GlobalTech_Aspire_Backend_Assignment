package com.globaltech.aspire.repository;

import com.globaltech.aspire.entity.Answer;
import com.globaltech.aspire.entity.AnswerComments;
import com.globaltech.aspire.entity.Tags;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswerCommentsRepository extends JpaRepository<AnswerComments, String> {

    @Query(value = "SELECT ac from AnswerComments ac where " +
            "ac.ansId=:ans_id")
    List<AnswerComments> queryBy(@Param("ans_id") Answer answer);
}
