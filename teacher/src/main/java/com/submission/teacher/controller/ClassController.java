package com.submission.teacher.controller;

import com.submission.common.api.CommonResult;
import com.submission.common.api.CommonResultUtil;
import com.submission.teacher.entity.ClassBase;
import com.submission.teacher.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author YangXiao
 * @since 2022/10/13 10:05
 */
@RestController
@RequestMapping("/class")
public class ClassController {

    @Autowired
    private ClassService classService;

    @PostMapping
    public CommonResult createClass(@RequestBody ClassBase classBase){
        int count = classService.createClass(classBase);
        return CommonResultUtil.processCommonResult(count);
    }

    @GetMapping("/list")
    public CommonResult listClass(){
        List<ClassBase> classBaseList = classService.listClass();
        return CommonResult.success(classBaseList,"成功");
    }


}
