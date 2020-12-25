package com.globaltech.aspire.repository;

import com.globaltech.aspire.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, String> {

    Question findByQuestionId(String questionId);

    @Query(value = "SELECT q from Question q where " +
            "q.companyId IN (:company_id)")
    List<Question> findQuestionsByCId(@Param("company_id") List<String> companyIds);
}
