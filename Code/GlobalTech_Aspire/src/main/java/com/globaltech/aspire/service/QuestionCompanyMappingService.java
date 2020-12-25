package com.globaltech.aspire.service;

import com.globaltech.aspire.entity.Question;
import com.globaltech.aspire.entity.QuestionCompanyMapping;

import java.util.List;

public interface QuestionCompanyMappingService {

    List<QuestionCompanyMapping> query(Question question);
}
