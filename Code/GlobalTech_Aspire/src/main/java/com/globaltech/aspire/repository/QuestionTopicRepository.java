package com.globaltech.aspire.repository;

import com.globaltech.aspire.entity.Question;
import com.globaltech.aspire.entity.QuestionTopic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionTopicRepository extends JpaRepository<QuestionTopic, String> {

    @Query(value = "SELECT qt from QuestionTopic qt where " +
            "qt.qId=:question_id")
    List<QuestionTopic> queryBy(@Param("question_id") Question question);

    @Query(value = "SELECT qt from QuestionTopic qt where " +
            "(qt.subTopic IN (:sub_topics) and qt.qId IN (:questions))")
    List<QuestionTopic> findBySubTopics(@Param("sub_topics") List<String> subTopics, @Param("questions") List<Question> questions);
}
