package com.submission.collection.service.impl;

import com.submission.collection.dto.SubmissionViewResult;
import com.submission.collection.entity.collection.Question;
import com.submission.collection.entity.collection.QuestionType;
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
    public List<SubmissionViewResult> getSubmissionList(String collectionId) {

        List<Question> question =
                questionRepository.findQuestionIdsByCollectionIdAndType(collectionId, QuestionType.Name.getType());

        List<String> questionIdList = question.stream().map(Question::getQuestionId).collect(Collectors.toList());

        List<Answer> nameSubmissionList =
                answerRepository.findDistinctAnswerContentByQuestionIdIn(questionIdList);

        List<SubmissionBrief> submissionBriefList = submissionRepository.findAllByCollectionId(collectionId);

        List<SubmissionViewResult> submissionViewResults = submissionBriefList.stream().map(submissionBrief -> {
            String submissionId = submissionBrief.getSubmissionId();
            String name = nameSubmissionList.stream().filter(answer -> answer.getSubmissionId().equals(submissionId))
                    .findFirst()
                    .map(answer -> answer.getAnswerContent().get(0))
                    .orElse(null);
            SubmissionViewResult submissionViewResult = new SubmissionViewResult();
            submissionViewResult.setSubmissionId(submissionId);
            submissionViewResult.setName(name);
            submissionViewResult.setSubmitTime(submissionBrief.getSubmitTime());
            return submissionViewResult;
        }).collect(Collectors.toList());

        return submissionViewResults;
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
