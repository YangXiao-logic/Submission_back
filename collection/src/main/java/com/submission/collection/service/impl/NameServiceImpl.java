package com.submission.collection.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import com.submission.collection.entity.name.CollectionName;
import com.submission.collection.mapper.CollectionNameMapper;
import com.submission.collection.mapper.UserNameMapper;
import com.submission.collection.service.NameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author YangXiao
 * @since 2023/2/5 10:13
 */
@Service
public class NameServiceImpl implements NameService {

    @Autowired
    private UserNameMapper userNameMapper;
    @Autowired
    private CollectionNameMapper collectionNameMapper;


    Snowflake snowflake = IdUtil.getSnowflake();


    @Override
    public List<String> getRemainNameList(String collectionId) {
        String userId = (String) StpUtil.getLoginId();
        List<String> userNameList = userNameMapper.getNameListByUserId(userId);
        List<String> collectionNameList = collectionNameMapper.getNameListByCollectionId(collectionId);
        collectionNameList.removeAll(userNameList);
        return collectionNameList;
    }

    @Override
    public int addCollectionNameList(List<String> nameStringList, String collectionId) {
        List<String> nameListByCollectionId = collectionNameMapper.getNameListByCollectionId(collectionId);
        nameStringList.removeAll(nameListByCollectionId);
        List<CollectionName> collectionNameList = nameStringList.stream().distinct().map(nameString -> {
            CollectionName collectionName = new CollectionName();
            collectionName.setName(nameString);
            collectionName.setCollectionId(collectionId);
            return collectionName;
        }).collect(Collectors.toList());
        return collectionNameMapper.insertBatch(collectionNameList);
    }

    @Override
    public List<String> getNameListByCollectionId(String collectionId) {
        return collectionNameMapper.getNameListByCollectionId(collectionId);
    }

}
