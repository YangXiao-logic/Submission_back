package com.submission.collection.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.submission.collection.entity.name.UserName;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author YangXiao
 * @since 2023/2/5 10:17
 */
@Mapper
public interface UserNameMapper extends BaseMapper<UserName> {

    List<String> getNameListByUserId(@Param("userId") String userId);

}
