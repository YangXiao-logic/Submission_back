package com.submission.student.service;

import com.submission.student.entity.Homework;

import java.util.List;

/**
 * @author YangXiao
 * @since 2022/10/12 21:26
 */
public interface HomeworkService {
    List<Homework> listHomework();

    int addHomework(String inviteCode);
}
