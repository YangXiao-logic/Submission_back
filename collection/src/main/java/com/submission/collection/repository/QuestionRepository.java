package com.submission.collection.repository;

import com.submission.collection.entity.collection.Question;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Map;

/**
 * @author YangXiao
 * @since 2022/11/22 10:00
 */
public interface QuestionRepository extends MongoRepository<Question,String> {

    List<Question> findAllByCollectionId(String collectionId);

    Question findByQuestionId(String questionId);

    int deleteAllByCollectionId(String collectionId);

    @Query(fields = "{questionId:1}")
    List<Question> findQuestionIdsByCollectionIdInAndType(List<String> collectionIds, String type);


    @Query(fields = "{questionId:1}")
    List<Question> findQuestionIdsByCollectionIdAndType(String collectionId, String type);

}
