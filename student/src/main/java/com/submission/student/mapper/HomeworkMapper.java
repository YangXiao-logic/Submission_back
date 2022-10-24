package com.submission.student.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.submission.student.entity.Homework;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author YangXiao
 * @since 2022/10/6 10:10
 */
@Mapper
public interface HomeworkMapper extends BaseMapper<Homework> {

    List<Homework> selectListByStudentId(@Param("studentId") String studentId);

}
