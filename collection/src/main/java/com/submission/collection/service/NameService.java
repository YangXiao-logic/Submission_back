package com.submission.collection.service;

import java.util.Set;

/**
 * @author YangXiao
 * @since 2023/2/5 9:36
 */
public interface NameService {

    Set<String> getNameList(String collectionId);

    Set<String> getRemainNameList(String collectionId);


    /**
     * add name list to collection, add name to user if name not exist in user
     * @param nameStringSet
     * @param collectionId
     * @return
     */
    int addNameListToCollection(Set<String> nameStringSet, String collectionId);

    /**
     * add name to collection from name history
     * @param nameString
     * @param collectionId
     * @return
     */
    int addNameToCollection(String nameString, String collectionId);

    /**
     * add name to user history.
     * @param nameString
     * @return
     */
    int addNameToUser(String nameString);

}
