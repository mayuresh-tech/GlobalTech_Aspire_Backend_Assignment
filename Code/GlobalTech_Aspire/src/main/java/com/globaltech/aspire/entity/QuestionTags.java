package com.globaltech.aspire.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "question_tags")
public class QuestionTags extends AuditEntity {

    @Id
    @Column(name = "question_tag_id")
    private String questionTagId;

    @ManyToOne
    @JoinColumn(name = "question_id", nullable = false)
    private Question qId;
}
