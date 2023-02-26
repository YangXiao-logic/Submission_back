package com.submission.collection.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.submission.collection.dto.CollectionHomeResult;
import com.submission.collection.entity.collection.Collection;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author YangXiao
 * @since 2022/10/17 15:17
 */
@Mapper
public interface CollectionMapper extends BaseMapper<Collection> {

    List<CollectionHomeResult> selectAllByUserId(@Param("userId") String userId);
}
