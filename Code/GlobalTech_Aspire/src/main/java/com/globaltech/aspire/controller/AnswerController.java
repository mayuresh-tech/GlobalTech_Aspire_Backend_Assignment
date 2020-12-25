package com.globaltech.aspire.controller;

import com.globaltech.aspire.dto.ResponseDTO;
import com.globaltech.aspire.entity.Answer;
import com.globaltech.aspire.service.AnswerService;
import com.globaltech.aspire.util.ErrorMessages;
import io.swagger.annotations.ApiOperation;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/answer")
@Validated
public class AnswerController extends BaseController {

    @Autowired
    AnswerService answerService;

    @ApiOperation(value = "Save Answer to a Question")
    @PostMapping(path = "/saveAnswer", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseDTO saveAnswerOfQuestion(@RequestParam String questionId, @RequestParam @Length(min = 50, max = 500) String answerDescription, @RequestParam String userId) throws Exception {
        Answer answer = new Answer();
        answer.setAnswerDescription(answerDescription);
        answer.setAnsweredById(userId);
        String result = answerService.saveAnswer(answer, questionId);

        if (!result.equals("Error")) {
            return new ResponseDTO(200, result, "Success");
        }
        else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ErrorMessages.ERROR_OCCURRED);
        }
    }
}
