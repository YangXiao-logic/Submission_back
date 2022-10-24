package com.submission.teacher.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.incrementer.H2KeyGenerator;
import com.submission.teacher.dto.CourseParam;
import com.submission.teacher.entity.CourseBase;
import com.submission.teacher.mapper.CourseMapper;
import com.submission.teacher.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.keyvalue.core.IdentifierGenerator;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * @author YangXiao
 * @since 2022/10/6 9:43
 */
@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseMapper courseMapper;

    @Override
    public int insertCourse(CourseBase courseBase) {
        String teacherId = (String) StpUtil.getLoginId();
        courseBase.setTeacherId(teacherId);
        courseMapper.insert(courseBase);
        return 1;
    }

    @Override
    public List<CourseBase> listCourse(String classId, String sortEnum) {
        QueryWrapper<CourseBase> courseQueryWrapper = new QueryWrapper<>();
        if(classId!=null){
            courseQueryWrapper.eq("class_id",classId);
        }
        List<CourseBase> courseBaseList = courseMapper.selectList(courseQueryWrapper);
        return courseBaseList;
    }


}
