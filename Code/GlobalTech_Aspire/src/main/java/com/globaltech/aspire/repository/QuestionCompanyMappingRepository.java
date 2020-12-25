package com.globaltech.aspire.repository;

import com.globaltech.aspire.entity.Question;
import com.globaltech.aspire.entity.QuestionCompanyMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionCompanyMappingRepository extends JpaRepository<QuestionCompanyMapping, String> {

    @Query(value = "SELECT qcm from QuestionCompanyMapping qcm where " +
            "qcm.qId=:question_id")
    List<QuestionCompanyMapping> queryBy(@Param("question_id") Question question);
}
