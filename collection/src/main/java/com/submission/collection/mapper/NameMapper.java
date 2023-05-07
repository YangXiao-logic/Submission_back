package com.submission.collection.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.submission.collection.entity.name.NameListCollection;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author YangXiao
 * @since 2023/2/8 10:16
 */
@Mapper
public interface NameMapper extends BaseMapper<NameListCollection> {
    List<String> getNameListByCollectionId(@Param("collectionId") String collectionId);

    int insertBatch(@Param("collectionNameList") List<NameListCollection> collectionNameList);

}
