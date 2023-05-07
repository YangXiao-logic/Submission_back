package com.submission.collection.service;

import com.submission.collection.dto.SubmissionViewResult;
import com.submission.collection.entity.submission.AnswerView;

import java.util.List;

/**
 * @author YangXiao
 * @since 2023/2/9 9:40
 */
public interface SubmissionService {
    List<SubmissionViewResult> getSubmissionList(String collectionId);

    List<AnswerView> getSubmissionAnswer(String submissionId);


}
