package com.submission.student.controller;

import com.submission.common.api.CommonResult;
import com.submission.common.api.CommonResultUtil;
import com.submission.student.entity.Homework;
import com.submission.student.service.HomeworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author YangXiao
 * @since 2022/10/8 15:52
 */
@RestController
@RequestMapping("/homework")
public class HomeworkController {

    @Autowired
    private HomeworkService homeworkService;

    @GetMapping("/list")
    public CommonResult listHomework(){
        List<Homework> homeworkBaseList = homeworkService.listHomework();
        return CommonResult.success(homeworkBaseList);
    }

    @PostMapping
    public CommonResult addHomework(@RequestBody String inviteCode){
        int count = homeworkService.addHomework(inviteCode);
        return CommonResultUtil.processCommonResult(count);
    }

}
