package com.submission.teacher.service;

import com.submission.teacher.dto.CourseParam;
import com.submission.teacher.entity.CourseBase;

import java.util.List;

/**
 * @author YangXiao
 * @since 2022/10/6 9:43
 */
public interface CourseService {
    int insertCourse(CourseBase courseBase);

    List<CourseBase> listCourse(String classId, String sortEnum);
}
