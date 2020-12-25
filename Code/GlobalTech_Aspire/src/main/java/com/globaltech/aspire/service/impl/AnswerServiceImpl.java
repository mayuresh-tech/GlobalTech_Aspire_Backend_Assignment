package com.globaltech.aspire.service.impl;

import com.globaltech.aspire.entity.Answer;
import com.globaltech.aspire.entity.Question;
import com.globaltech.aspire.repository.AnswerRepository;
import com.globaltech.aspire.repository.QuestionRepository;
import com.globaltech.aspire.service.AnswerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
@Slf4j
public class AnswerServiceImpl implements AnswerService {

    @Autowired
    AnswerRepository answerRepository;

    @Autowired
    QuestionRepository questionRepository;

    @Override
    public String saveAnswer(Answer answer, String questionId) throws Exception {
        Question question = questionRepository.findByQuestionId(questionId);
        if (question != null) {
            answer.setCreatedAt(new Date());
            answer.setUpdatedAt(new Date());
            answer.setAnswerId(UUID.randomUUID().toString());
            answer.setQId(question);
            answerRepository.save(answer);

            if (answerRepository.findByAnswerId(answer.getAnswerId()) != null) {
                return answer.getAnswerId();
            }
            else {
                return "Error";
            }
        }
        else {
            return "Error";
        }
    }

    @Override
    public List<Answer> query(Question question) {
        return answerRepository.queryBy(question);
    }
}
