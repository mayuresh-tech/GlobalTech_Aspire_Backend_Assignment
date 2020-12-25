package com.globaltech.aspire.repository;

import com.globaltech.aspire.entity.Question;
import com.globaltech.aspire.entity.QuestionTags;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionTagsRepository extends JpaRepository<QuestionTags, String> {

    @Query(value = "SELECT t from QuestionTags t where " +
            "t.qId=:question_id")
    List<QuestionTags> queryBy(@Param("question_id") Question question);
}
