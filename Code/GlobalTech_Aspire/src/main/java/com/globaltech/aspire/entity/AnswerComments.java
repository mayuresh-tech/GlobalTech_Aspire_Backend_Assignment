package com.globaltech.aspire.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Getter
@Setter
@Table(name = "answer_comments")
public class AnswerComments extends AuditEntity {

    @Id
    @Column(name = "comment_id", unique = true)
    private String commentId;

    @Column(name = "comment")
    @Size(min = 50, max = 500)
    private String comment;

    @Column(name = "user_id")
    private String userId;

    @ManyToOne
    @JoinColumn(name = "ans_id", nullable = false)
    private Answer ansId;

}
