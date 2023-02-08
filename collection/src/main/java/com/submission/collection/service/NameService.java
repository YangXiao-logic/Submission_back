package com.submission.collection.service;

import java.util.List;
import java.util.Set;

/**
 * @author YangXiao
 * @since 2023/2/5 9:36
 */
public interface NameService {

    List<String> getRemainNameList(String collectionId);


    /**
     * add name list to collection
     * @param nameStringSet
     * @param collectionId
     * @return
     */
    int addCollectionNameList(List<String> nameStringList, String collectionId);



    List<String> getNameListByCollectionId(String collectionId);
}
