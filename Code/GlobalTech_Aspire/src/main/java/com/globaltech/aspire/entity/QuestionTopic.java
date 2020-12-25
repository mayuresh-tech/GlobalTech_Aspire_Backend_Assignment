package com.globaltech.aspire.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "question_topic")
public class QuestionTopic extends AuditEntity {

    @Id
    @Column(name = "topic_id", unique = true)
    private String topicId;

    @ManyToOne
    @JoinColumn(name = "question_id", nullable = false)
    private Question qId;

    @Column(name = "topic_name")
    private String topicName;

    @Column(name = "subtopic")
    private String subTopic;

}
