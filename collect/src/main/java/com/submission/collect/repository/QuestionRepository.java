package com.submission.collect.repository;

import com.submission.collect.entity.collection.Question;
import com.submission.collect.entity.collection.QuestionData;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * @author YangXiao
 * @since 2022/11/22 10:00
 */
public interface QuestionRepository extends MongoRepository<Question,String> {

    List<Question> findAllByCollectionId(String collectionId);

}
