package com.submission.collection.repository;

import com.submission.collection.entity.submission.Answer;
import com.submission.collection.entity.submission.SubmissionBrief;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * @author YangXiao
 * @since 2023/2/9 10:09
 */
public interface SubmissionRepository extends MongoRepository<SubmissionBrief, String> {
    List<SubmissionBrief> findAllByCollectionId(String collectionId);

    int countByCollectionId(String collectionId);

    int deleteAllByCollectionId(String collectionId);
}
