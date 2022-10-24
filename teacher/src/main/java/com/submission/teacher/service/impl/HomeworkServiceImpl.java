package com.submission.teacher.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.submission.teacher.dto.HomeworkSortEnum;
import com.submission.teacher.entity.HomeworkBase;
import com.submission.teacher.mapper.HomeworkMapper;
import com.submission.teacher.service.HomeworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author YangXiao
 * @since 2022/10/8 11:00
 */
@Service
public class HomeworkServiceImpl implements HomeworkService {


    @Autowired
    private HomeworkMapper homeworkMapper;

    @Override
    public List<HomeworkBase> listHomework() {
        QueryWrapper<HomeworkBase> homeworkBaseWrapper = new QueryWrapper<>();
        String teacherId = (String) StpUtil.getLoginId();
        homeworkBaseWrapper.eq("teacher_id",teacherId);
        return homeworkMapper.selectList(homeworkBaseWrapper);
    }

    @Override
    public List<HomeworkBase> listHomework(HomeworkSortEnum sort) {

        QueryWrapper<HomeworkBase> homeworkBaseWrapper = new QueryWrapper<>();
        String teacherId = (String) StpUtil.getLoginId();
        homeworkBaseWrapper.eq("teacher_id",teacherId);
        return homeworkMapper.selectList(homeworkBaseWrapper);
    }

    @Override
    public int createHomework(HomeworkBase homeworkBase) {
        String loginId = (String) StpUtil.getLoginId();
        homeworkBase.setTeacherId(loginId);
        return homeworkMapper.insert(homeworkBase);
    }
}
