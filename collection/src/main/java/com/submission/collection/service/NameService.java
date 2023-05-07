package com.submission.collection.service;

import java.util.List;

/**
 * @author YangXiao
 * @since 2023/2/5 9:36
 */
public interface NameService {



    /**
     * add name list to collection
     * @param nameStringSet
     * @param collectionId
     * @return
     */
    int addNameList(List<String> nameStringList, String collectionId);

    List<String> getNameListByCollectionId(String collectionId);

    int putNameList(String collectionId, List<String> nameList);

    int addName(String collectionId, String name);

    int deleteName(String collectionId, String name);


}
