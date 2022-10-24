package com.submission.collect.service;

import com.submission.collect.entity.CollectBase;

import java.util.List;

/**
 * @author YangXiao
 * @since 2022/10/17 15:14
 */
public interface CollectService {
    int createCollect(CollectBase collectBase);

    CollectBase getCollect(String collectId);
}
