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

    String userId = (String) StpUtil.getLoginId();
    Snowflake snowflake = IdUtil.getSnowflake();





    @Override
    public List<String> getRemainNameList(String collectionId) {
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
        int i = collectionNameMapper.insertBatch(collectionNameList);
        return i;
    }

    @Override
    public int addCollectionNameList(Set<String> nameStringSet, String collectionId) {
        Set<String> allNameSet = userNameMapper.getNameListByUserId(userId);
        Set<CollectionName> nameSet = nameStringSet.stream().filter(nameString -> !allNameSet.contains(nameString)).map(nameString -> {
            CollectionName name = new CollectionName();
            name.setNameId(snowflake.nextIdStr());
            name.setCollectionId(collectionId);
            name.setName_(nameString);
            name.setUserId(userId);
            return name;
        }).collect(Collectors.toSet());
        return userNameMapper.insertNameBatch(nameSet);
    }

    @Override
    public List<String> getNameListByCollectionId(String collectionId) {
        return collectionNameMapper.getNameListByCollectionId(collectionId);
    }

    @Override
    public int addNameToCollection(String nameString, String collectionId) {
        CollectionName name = new CollectionName();
        name.setNameId(snowflake.nextIdStr());
        name.setCollectionId(collectionId);
        name.setName_(nameString);
        name.setUserId(userId);
        return userNameMapper.insertName(name);
    }

    @Override
    public int addNameToUser(String nameString) {
        return 0;
    }
}
