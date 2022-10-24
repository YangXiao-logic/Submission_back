package com.submission.teacher.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.submission.teacher.dto.CourseParam;
import com.submission.teacher.entity.CourseBase;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author YangXiao
 * @since 2022/10/6 10:10
 */
@Mapper
public interface CourseMapper extends BaseMapper<CourseBase> {

    int insert(CourseParam courseParam);
}
