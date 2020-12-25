package com.globaltech.aspire.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "question")
public class Question extends AuditEntity {

    @Id
    @Column(name = "question_id", unique = true)
    private String questionId;

    @Column(name = "question_title", length = 100)
    private String questionTitle;

    @Column(name = "question_description")
    @Size(min = 50, max = 500)
    private String questionDescription;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "company_asked")
    private String companyAsked;

    @Column(name = "company_id")
    private String companyId;
}
