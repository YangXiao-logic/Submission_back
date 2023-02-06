package com.submission.collection.mapper;

import com.submission.collection.entity.name.Name;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Set;

/**
 * @author YangXiao
 * @since 2023/2/5 10:17
 */
@Mapper
public interface NameMapper {

    Set<String> getNameList(@Param("collectionId") String collectionId);

    Set<String> getAllNameSet(@Param("userId") String userId);

    /**
     * add name in collection from user name list
     * @param name
     * @return
     */
    int insertNameToCollectionFromUser(Name name);


    int insertNameToUser(Name name);

    /**
     * add name in collection and user.
     * @param nameList
     * @return
     */
    int insertNameBatch(@Param("nameList") Set<Name> nameList);



}
