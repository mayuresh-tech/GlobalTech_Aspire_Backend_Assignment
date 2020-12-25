package com.globaltech.aspire.repository;

import com.globaltech.aspire.entity.QuestionTags;
import com.globaltech.aspire.entity.Tags;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TagsRepository extends JpaRepository<Tags, String> {

    @Query(value = "SELECT t from Tags t where " +
            "t.qTId=:question_tag_id")
    List<Tags> queryBy(@Param("question_tag_id") QuestionTags questionTags);
}
