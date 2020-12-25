package com.globaltech.aspire.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "tags")
public class Tags extends AuditEntity {

    @Id
    @Column(name = "tag_id")
    private String tagId;

    @Column(name = "tags")
    private String tags;

    @ManyToOne
    @JoinColumn(name = "question_tag_id", nullable = false)
    private QuestionTags qTId;

}
