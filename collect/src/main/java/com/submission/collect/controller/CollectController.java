package com.submission.collect.controller;

import com.submission.collect.entity.collection.Collection;
import com.submission.collect.service.CollectService;
import com.submission.common.api.CommonResult;
import com.submission.common.api.CommonResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public CommonResult createCollect(@RequestBody Collection collection){
        int count=collectService.createCollect(collection);
        return CommonResultUtil.processCommonResult(count);
    }

    @GetMapping
    public CommonResult getCollect(@RequestParam String collectionId){
        Collection collect = collectService.getCollect(collectionId);
        return CommonResult.success(collect);
    }

    @GetMapping("/list")
    public CommonResult listCollect(){
        List<Collection> collectionList = collectService.listCollect();
        return CommonResult.success(collectionList);
    }






}
