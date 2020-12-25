package com.globaltech.aspire.controller;

import com.globaltech.aspire.dto.ResponseDTO;
import com.globaltech.aspire.service.AnswerLikesService;
import com.globaltech.aspire.service.QuestionLikesService;
import com.globaltech.aspire.util.ErrorMessages;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/likes")
@Validated
public class LikesController extends BaseController {

    @Autowired
    QuestionLikesService questionLikesService;

    @Autowired
    AnswerLikesService answerLikesService;

    @ApiOperation(value = "Give a like to Question")
    @PostMapping(path = "/giveQuestionLike", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseDTO saveQuestionLike(@RequestParam String questionId, @RequestParam String userId) throws Exception {
        boolean result = questionLikesService.saveLikeForQuestion(questionId, userId);

        if (result) {
            return new ResponseDTO(200, "Like saved Successfully", "Success");
        }
        else {
            throw new ResponseStatusException(HttpStatus.PRECONDITION_FAILED, ErrorMessages.LIKE_ALREADY_PRESENT);
        }
    }

    @ApiOperation(value = "Give a like to Answer")
    @PostMapping(path = "/giveAnswerLike", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseDTO saveAnswerLike(@RequestParam String answerId, @RequestParam String userId) throws Exception {
        boolean result = answerLikesService.saveLikeForAnswer(answerId, userId);

        if (result) {
            return new ResponseDTO(200, "Like saved Successfully", "Success");
        }
        else {
            throw new ResponseStatusException(HttpStatus.PRECONDITION_FAILED, ErrorMessages.LIKE_ALREADY_PRESENT);
        }
    }

    @ApiOperation(value = "Check like to an Answer")
    @GetMapping(path = "/checkAnswerLike", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseDTO checkAnswerLike(@RequestParam String answerId, @RequestParam String userId) throws Exception {
        boolean result = answerLikesService.checkAnswerLike(answerId, userId);

        if (!result) {
            return new ResponseDTO(404, "Like not Found", "Success");
        }
        else {
            return new ResponseDTO(200, "Like Found", "Success");
        }
    }

    @ApiOperation(value = "Check like to a Question")
    @GetMapping(path = "/checkQuestionLike", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseDTO checkQuestionLike(@RequestParam String questionId, @RequestParam String userId) throws Exception {
        boolean result = questionLikesService.checkQuestionLike(questionId, userId);

        if (!result) {
            return new ResponseDTO(404, "Like not Found", "Success");
        }
        else {
            return new ResponseDTO(200, "Like Found", "Success");
        }
    }

}
