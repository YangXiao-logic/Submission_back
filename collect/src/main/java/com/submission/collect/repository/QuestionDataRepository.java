package com.submission.collect.repository;

import com.submission.collect.entity.collection.QuestionData;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author YangXiao
 * @since 2022/11/21 10:55
 */
public interface QuestionDataRepository extends MongoRepository<QuestionData,String> {
}
