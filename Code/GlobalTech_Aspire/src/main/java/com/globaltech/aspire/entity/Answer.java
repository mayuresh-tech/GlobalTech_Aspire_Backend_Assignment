package com.globaltech.aspire.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Getter
@Setter
@Table(name = "answers")
public class Answer extends AuditEntity {

    @Id
    @Column(name = "answer_id")
    private String answerId;

    @ManyToOne
    @JoinColumn(name = "question_id", nullable = false)
    private Question qId;

    @Column(name = "answer_description")
    @Size(min = 50, max = 500)
    private String answerDescription;

    @Column(name = "user_id")
    private String answeredById;
}
