package com.globaltech.aspire.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@Table(name = "answer_likes")
public class AnswerLikes extends AuditEntity {

    @Id
    @Column(name = "answer_likes_id")
    private String id;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "answer_id")
    private String answerId;

}
