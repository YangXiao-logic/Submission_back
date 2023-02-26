package com.submission.collection.service;

import com.submission.collection.dto.CollectionHomeResult;
import com.submission.collection.entity.collection.Collection;
import com.submission.collection.dto.CollectionDetailResult;

import java.util.List;

/**
 * @author YangXiao
 * @since 2022/10/17 15:14
 */
public interface CollectionService {
    int createCollection(Collection collection);

    Collection getCollection(String collectId);

    List<CollectionHomeResult> getCollectionHomeResultList();

    int deleteCollection(String collectionId);

    int stopCollection(String collectionId);

    int copyCollection(String collectionId);

    CollectionDetailResult getDetailCollection(String collectionId);

    int updateCollection(Collection collection);
}
