package com.submission.teacher.controller;

import com.submission.common.api.CommonResult;
import com.submission.teacher.dto.CourseParam;
import com.submission.teacher.entity.CourseBase;
import com.submission.teacher.service.CourseService;
import org.checkerframework.checker.units.qual.C;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author YangXiao
 * @since 2022/10/6 9:42
 */
@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping
    public CommonResult createCourse(@RequestBody CourseBase courseBase){
        courseService.insertCourse(courseBase);
        return CommonResult.success(null,"成功");
    }

    @GetMapping("/list")
    public CommonResult listCourse(@RequestParam(required = false) String classId,
                                   @RequestParam(required = false) String sortEnum){
        List<CourseBase> courseBaseList = courseService.listCourse(classId, sortEnum);
        return CommonResult.success(courseBaseList);
    }


}
