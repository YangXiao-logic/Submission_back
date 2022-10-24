package com.submission.teacher.service;

import com.submission.teacher.dto.HomeworkSortEnum;
import com.submission.teacher.entity.HomeworkBase;

import java.util.List;

/**
 * @author YangXiao
 * @since 2022/10/8 9:26
 */
public interface HomeworkService {


    List<HomeworkBase> listHomework();

    List<HomeworkBase> listHomework(HomeworkSortEnum sort);

    int createHomework(HomeworkBase homeworkBase);
}
