package com.globaltech.aspire.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "question_company_mapping")
public class QuestionCompanyMapping extends AuditEntity {

    @Id
    @Column(name = "question_company_mapping_id")
    private String qCMId;

    @ManyToOne
    @JoinColumn(name = "question_id", nullable = false)
    private Question qId;

    @Column(name = "qcm_companies_asked")
    private String companiesAsked;

}
