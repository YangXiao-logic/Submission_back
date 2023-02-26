package com.submission.collection.service;

import com.submission.collection.entity.submission.Answer;
import com.submission.collection.entity.submission.AnswerView;
import com.submission.collection.entity.submission.Submission;
import com.submission.collection.entity.submission.SubmissionBrief;

import java.util.List;

/**
 * @author YangXiao
 * @since 2023/2/9 9:40
 */
public interface SubmissionService {
    List<SubmissionBrief> getSubmissionList(String collectionId);

    List<AnswerView> getSubmissionAnswer(String submissionId);
}
