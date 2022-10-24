package com.submission.teacher.mapper;

import com.submission.teacher.dto.CourseParam;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author YangXiao
 * @since 2022/10/6 12:35
 */
@SpringBootTest
class CourseMapperTest {

    @Autowired
    private CourseMapper courseMapper;

    @Test
    void insert() {
        CourseParam courseParam = new CourseParam();
        courseParam.setCourseName("course1");
        courseParam.setCourseDescription("course1");
        courseMapper.insert(courseParam);
        System.out.println(courseParam);
    }
}
