package com.submission.collection.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import com.submission.collection.entity.name.Name;
import com.submission.collection.mapper.NameMapper;
import com.submission.collection.service.NameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author YangXiao
 * @since 2023/2/5 10:13
 */
@Service
public class NameServiceImpl implements NameService {

    @Autowired
    private NameMapper nameMapper;

    String userId = (String) StpUtil.getLoginId();
    Snowflake snowflake = IdUtil.getSnowflake();

    @Override
    public Set<String> getNameList(String collectionId) {
        return nameMapper.getNameList(collectionId);
    }

    @Override
    public Set<String> getRemainNameList(String collectionId) {
        Set<String> allNameList = nameMapper.getAllNameSet(userId);
        Set<String> nameList = nameMapper.getNameList(collectionId);
        allNameList.removeAll(nameList);
        return allNameList;
    }

    @Override
    public int addNameListToCollection(Set<String> nameStringSet, String collectionId) {
        Set<String> allNameSet = nameMapper.getAllNameSet(userId);
        Set<Name> nameSet = nameStringSet.stream().filter(nameString -> !allNameSet.contains(nameString)).map(nameString -> {
            Name name = new Name();
            name.setNameId(snowflake.nextIdStr());
            name.setCollectionId(collectionId);
            name.setName_(nameString);
            name.setUserId(userId);
            return name;
        }).collect(Collectors.toSet());
        return nameMapper.insertNameBatch(nameSet);
    }

    @Override
    public int addNameToCollection(String nameString, String collectionId) {
        Name name = new Name();
        name.setNameId(snowflake.nextIdStr());
        name.setCollectionId(collectionId);
        name.setName_(nameString);
        name.setUserId(userId);
        return nameMapper.insertName(name);
    }

    @Override
    public int addNameToUser(String nameString) {
        return 0;
    }
}
