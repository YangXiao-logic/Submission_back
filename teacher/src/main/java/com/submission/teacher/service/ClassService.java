package com.submission.teacher.service;

import com.submission.teacher.entity.ClassBase;

import java.util.List;

/**
 * @author YangXiao
 * @since 2022/10/13 10:08
 */
public interface ClassService {

    int createClass(ClassBase classBase);

    List<ClassBase> listClass();

}
