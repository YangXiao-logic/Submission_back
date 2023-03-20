package com.submission.collection.repository;

import com.submission.collection.entity.collection.Question;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * @author YangXiao
 * @since 2022/11/22 10:00
 */
public interface QuestionRepository extends MongoRepository<Question,String> {

    List<Question> findAllByCollectionId(String collectionId);

    Question findByQuestionId(String questionId);

    int deleteAllByCollectionId(String collectionId);

    List<String> findDistinctQuetionIdByCollectionIdInAndType(List<String> collectionIds, String type);




}
