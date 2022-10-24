package com.submission.collect.repository;

import com.submission.collect.entity.Question;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author YangXiao
 * @since 2022/10/17 14:29
 */
public interface QuestionRepository extends MongoRepository<Question,String> {

    List<Question> findAllByCollectId(String collectId);
}
