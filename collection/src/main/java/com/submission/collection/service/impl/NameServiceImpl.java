package com.submission.collection.service.impl;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.submission.collection.entity.name.CollectionName;
import com.submission.collection.mapper.NameMapper;
import com.submission.collection.service.NameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author YangXiao
 * @since 2023/2/5 10:13
 */
@Service
public class NameServiceImpl implements NameService {
    @Autowired
    private NameMapper nameMapper;


    Snowflake snowflake = IdUtil.getSnowflake();


    @Override
    public int addNameList(List<String> nameStringList, String collectionId) {
        List<String> nameListByCollectionId = nameMapper.getNameListByCollectionId(collectionId);
        nameStringList.removeAll(nameListByCollectionId);
        List<CollectionName> collectionNameList = nameStringList.stream().distinct().map(nameString -> {
            CollectionName collectionName = new CollectionName();
            collectionName.setName(nameString);
            collectionName.setNameId(snowflake.nextIdStr());
            collectionName.setCollectionId(collectionId);
            return collectionName;
        }).collect(Collectors.toList());
        return nameMapper.insertBatch(collectionNameList);
    }

    @Override
    public List<String> getNameListByCollectionId(String collectionId) {
        return nameMapper.getNameListByCollectionId(collectionId);
    }


    @Override
    public int deleteCollectionName(String name){
        QueryWrapper<CollectionName> objectQueryWrapper = new QueryWrapper<CollectionName>().eq("name", name);
        return nameMapper.delete(objectQueryWrapper);
    }

}
