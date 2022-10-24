package com.submission.collect.controller;

import com.submission.collect.entity.CollectBase;
import com.submission.collect.service.CollectService;
import com.submission.common.api.CommonResult;
import com.submission.common.api.CommonResultUtil;
import org.checkerframework.checker.units.qual.C;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author YangXiao
 * @since 2022/10/15 10:46
 */
@RestController
@RequestMapping("/collect")
public class CollectController {

    @Autowired
    private CollectService collectService;

    @PostMapping
    public CommonResult createCollect(@RequestBody CollectBase collectBase){
        int count=collectService.createCollect(collectBase);
        return CommonResultUtil.processCommonResult(count);
    }

    @GetMapping
    public CommonResult getCollect(@RequestParam String collectId){
        CollectBase collect = collectService.getCollect(collectId);
        return CommonResult.success(collect);
    }




}
