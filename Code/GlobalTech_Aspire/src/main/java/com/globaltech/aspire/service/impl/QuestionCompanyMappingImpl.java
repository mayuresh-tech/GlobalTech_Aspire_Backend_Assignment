package com.globaltech.aspire.service.impl;

import com.globaltech.aspire.entity.Question;
import com.globaltech.aspire.entity.QuestionCompanyMapping;
import com.globaltech.aspire.repository.QuestionCompanyMappingRepository;
import com.globaltech.aspire.service.QuestionCompanyMappingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class QuestionCompanyMappingImpl implements QuestionCompanyMappingService {

    @Autowired
    QuestionCompanyMappingRepository questionCompanyMappingRepository;

    @Override
    public List<QuestionCompanyMapping> query(Question question) {
        return questionCompanyMappingRepository.queryBy(question);
    }
}
