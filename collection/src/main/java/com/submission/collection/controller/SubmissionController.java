package com.submission.collection.controller;

import com.submission.collection.entity.submission.Answer;
import com.submission.collection.entity.submission.AnswerView;
import com.submission.collection.entity.submission.Submission;
import com.submission.collection.entity.submission.SubmissionBrief;
import com.submission.collection.service.SubmissionService;
import com.submission.common.api.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author YangXiao
 * @since 2023/2/9 9:36
 */
@RestController
@RequestMapping("/submissions")
public class SubmissionController {

    @Autowired
    private SubmissionService submissionService;


    @GetMapping("/{submissionId}")
    CommonResult getSubmissionAnswer(@PathVariable String submissionId) {
        List<AnswerView> answerList = submissionService.getSubmissionAnswer(submissionId);
        return CommonResult.success(answerList);
    }
}

