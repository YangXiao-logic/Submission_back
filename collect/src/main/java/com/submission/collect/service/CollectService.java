package com.submission.collect.service;

import com.submission.collect.entity.collection.Collection;

import java.util.List;

/**
 * @author YangXiao
 * @since 2022/10/17 15:14
 */
public interface CollectService {
    int createCollect(Collection collection);

    Collection getCollect(String collectId);

    List<Collection> listCollect();
}
