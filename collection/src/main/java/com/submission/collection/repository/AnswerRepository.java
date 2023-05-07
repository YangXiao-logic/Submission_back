package com.submission.collection.repository;

import com.submission.collection.entity.submission.Answer;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * @author YangXiao
 * @since 2023/2/8 17:39
 */
public interface AnswerRepository extends MongoRepository<Answer, String> {

    List<Answer> findAllBySubmissionId(String submissionId);

    List<Answer> findDistinctAnswerContentByQuestionIdIn(List<String> questionIds);




}
