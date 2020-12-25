package com.globaltech.aspire.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@Table(name = "question_likes")
public class QuestionLikes extends AuditEntity {

    @Id
    @Column(name = "questionlikes_id")
    private String id;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "question_id")
    private String questionId;

}
