package com.submission.student.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import com.submission.student.entity.Homework;
import com.submission.student.mapper.HomeworkMapper;
import com.submission.student.service.HomeworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author YangXiao
 * @since 2022/10/12 21:27
 */
@Service
public class HomeworkServiceImpl implements HomeworkService {

    @Autowired
    private HomeworkMapper homeworkMapper;

    @Override
    public List<Homework> listHomework() {
        String studentId = (String) StpUtil.getLoginId();

        return null;
    }
}
