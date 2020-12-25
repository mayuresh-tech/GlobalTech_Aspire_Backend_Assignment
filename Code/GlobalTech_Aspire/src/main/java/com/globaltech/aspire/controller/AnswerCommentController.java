package com.globaltech.aspire.controller;

import com.globaltech.aspire.dto.ResponseDTO;
import com.globaltech.aspire.service.AnswerCommentsService;
import com.globaltech.aspire.util.ErrorMessages;
import io.swagger.annotations.Api;
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
@RequestMapping("/answerComment")
@Validated
public class AnswerCommentController {

    @Autowired
    AnswerCommentsService answerCommentsService;

    @ApiOperation(value = "Save Comment for an Answer")
    @PostMapping(path = "saveComment", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseDTO saveAnswerComment(@RequestParam String userId, @RequestParam String answerId, @RequestParam @Length(min = 50, max = 500) String comment) throws Exception {
        String result = answerCommentsService.saveAnswerComment(answerId, userId, comment);

        if (!result.equals("Error")) {
            return new ResponseDTO(200, result, "Success");
        }
        else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ErrorMessages.ERROR_OCCURRED);
        }
    }

}
