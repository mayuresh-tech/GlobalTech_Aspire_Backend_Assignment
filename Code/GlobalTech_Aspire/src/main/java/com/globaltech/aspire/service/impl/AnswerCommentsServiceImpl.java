package com.globaltech.aspire.service.impl;

import com.globaltech.aspire.entity.Answer;
import com.globaltech.aspire.entity.AnswerComments;
import com.globaltech.aspire.repository.AnswerCommentsRepository;
import com.globaltech.aspire.repository.AnswerRepository;
import com.globaltech.aspire.service.AnswerCommentsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class AnswerCommentsServiceImpl implements AnswerCommentsService {

    @Autowired
    AnswerCommentsRepository answerCommentsRepository;

    @Autowired
    AnswerRepository answerRepository;

    @Override
    public String saveAnswerComment(String answerId, String userId, String comment) throws Exception {
        AnswerComments answerComments = new AnswerComments();
        answerComments.setCreatedAt(new Date());
        answerComments.setUpdatedAt(new Date());
        answerComments.setCommentId(UUID.randomUUID().toString());
        answerComments.setComment(comment);
        answerComments.setAnsId(answerRepository.findByAnswerId(answerId));
        answerComments.setUserId(userId);

        answerCommentsRepository.save(answerComments);

        if (answerCommentsRepository.existsById(answerComments.getCommentId())) {
            return answerComments.getCommentId();
        }
        else {
            return "Error";
        }
    }

    @Override
    public List<AnswerComments> query(Answer answer) {
        return answerCommentsRepository.queryBy(answer);
    }
}
