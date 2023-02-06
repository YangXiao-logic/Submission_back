package com.submission.collection.repository;

import com.submission.collection.entity.collection.QuestionData;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author YangXiao
 * @since 2022/11/21 10:55
 */
public interface QuestionDataRepository extends MongoRepository<QuestionData,String> {
}
