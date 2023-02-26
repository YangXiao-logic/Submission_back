package com.submission.collection.service.impl;

import com.submission.collection.entity.collection.Question;
import com.submission.collection.entity.submission.Answer;
import com.submission.collection.entity.submission.AnswerView;
import com.submission.collection.entity.submission.SubmissionBrief;
import com.submission.collection.repository.AnswerRepository;
import com.submission.collection.repository.QuestionRepository;
import com.submission.collection.repository.SubmissionRepository;
import com.submission.collection.service.SubmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author YangXiao
 * @since 2023/2/9 10:00
 */
@Service
public class SubmissionServiceImpl implements SubmissionService {

    @Autowired
    private AnswerRepository answerRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private SubmissionRepository submissionRepository;

    @Override
    public List<SubmissionBrief> getSubmissionList(String collectionId) {
        List<SubmissionBrief> submissionBriefList = submissionRepository.findAllByCollectionId(collectionId);
        return submissionBriefList;
    }

    @Override
    public List<AnswerView> getSubmissionAnswer(String submissionId) {
        List<Answer> answerList = answerRepository.findAllBySubmissionId(submissionId);
        List<AnswerView> answerViewList = answerList.stream().map(answer -> {
            AnswerView answerView = new AnswerView();
            answerView.setAnswerContent(answer.getAnswerContent());
            Question question = questionRepository.findByQuestionId(answer.getQuestionId());
            answerView.setQuestionName(question.getName());
            return answerView;
        }).collect(Collectors.toList());
        return answerViewList;
    }
}
