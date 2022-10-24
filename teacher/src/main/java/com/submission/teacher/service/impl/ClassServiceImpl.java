package com.submission.teacher.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.submission.common.exception.Asserts;
import com.submission.teacher.entity.ClassBase;
import com.submission.teacher.mapper.ClassMapper;
import com.submission.teacher.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author YangXiao
 * @since 2022/10/13 10:12
 */
@Service
public class ClassServiceImpl implements ClassService {

    @Autowired
    private ClassMapper classMapper;

    @Override
    public int createClass(ClassBase classBase) {
        String teacherId = (String) StpUtil.getLoginId();
        QueryWrapper<ClassBase> classBaseQueryWrapper = new QueryWrapper<>();
        classBaseQueryWrapper.eq("teacher_id",teacherId);
        classBaseQueryWrapper.eq("class_name",classBase.getClassName());
        List<ClassBase> classBaseList = classMapper.selectList(classBaseQueryWrapper);
        if(classBaseList.size()!=0){
            Asserts.fail("该班级已存在");
        }
        classBase.setTeacherId(teacherId);
        return classMapper.insert(classBase);
    }

    @Override
    public List<ClassBase> listClass() {
        String teacherId = (String) StpUtil.getLoginId();
        QueryWrapper<ClassBase> classBaseQueryWrapper = new QueryWrapper<>();
        classBaseQueryWrapper.eq("teacher_id",teacherId);
        List<ClassBase> classBaseList = classMapper.selectList(classBaseQueryWrapper);
        return classBaseList;
    }
}
