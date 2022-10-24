package com.submission.teacher.controller;

import com.submission.common.api.CommonResult;
import com.submission.common.api.CommonResultUtil;
import com.submission.teacher.dto.HomeworkSortEnum;
import com.submission.teacher.entity.HomeworkBase;
import com.submission.teacher.service.HomeworkService;
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
    public CommonResult listHomeworkByTeacherId(@RequestParam String sortEnum){
        List<HomeworkBase> homeworkBaseList = homeworkService.listHomework();
        return CommonResult.success(homeworkBaseList);
    }

    @PostMapping
    public CommonResult createHomework(@RequestBody HomeworkBase homeworkBase){
        int count = homeworkService.createHomework(homeworkBase);
        return CommonResultUtil.processCommonResult(count);
    }

}
