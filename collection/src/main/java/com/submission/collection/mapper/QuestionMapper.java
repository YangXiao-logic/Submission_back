package com.submission.collection.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.submission.collection.entity.collection.Question;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author YangXiao
 * @since 2022/11/21 10:10
 */
@Mapper
public interface QuestionMapper extends BaseMapper<Question> {

    int insertBatch(@Param("questionList") List<Question> questionList);
}
