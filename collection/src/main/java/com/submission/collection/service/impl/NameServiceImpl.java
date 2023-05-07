package com.submission.collection.service.impl;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.submission.collection.entity.name.NameListCollection;
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
        List<NameListCollection> collectionNameList = nameStringList.stream().distinct().map(nameString -> {
            NameListCollection collectionName = new NameListCollection();
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
    public int putNameList(String collectionId, List<String> nameList) {

        List<String> nameListByCollectionId = getNameListByCollectionId(collectionId);
        List<String> newName =
                nameList.stream().filter(name -> !nameListByCollectionId.contains(name)).collect(Collectors.toList());
        List<String> nameDeleted =
                nameListByCollectionId.stream().filter(name -> !nameList.contains(name)).collect(Collectors.toList());


        QueryWrapper<NameListCollection> nameListCollectionQueryWrapper = new QueryWrapper<>();
        nameListCollectionQueryWrapper.eq("collection_id",collectionId);
        nameListCollectionQueryWrapper.in("name",nameDeleted);

        addNameList(newName, collectionId);
        nameMapper.delete(nameListCollectionQueryWrapper);
        return 1;
    }

    @Override
    public int addName(String collectionId, String name) {
        NameListCollection nameListCollection = new NameListCollection();
        nameListCollection.setName(name);
        nameListCollection.setNameId(snowflake.nextIdStr());
        nameListCollection.setCollectionId(collectionId);
        nameMapper.insert(nameListCollection);
        return 1;
    }

    @Override
    public int deleteName(String collectionId, String name) {
        QueryWrapper<NameListCollection> nameListCollectionQueryWrapper = new QueryWrapper<>();
        nameListCollectionQueryWrapper.eq("collection_id", collectionId);
        nameListCollectionQueryWrapper.eq("name", name);
        return nameMapper.delete(nameListCollectionQueryWrapper);
    }

}
