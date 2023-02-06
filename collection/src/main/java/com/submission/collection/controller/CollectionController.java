package com.submission.collection.controller;

import com.submission.collection.entity.collection.Collection;
import com.submission.collection.service.CollectService;
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
@RequestMapping("/collections")
public class CollectionController {

    @Autowired
    private CollectService collectService;

    @PostMapping
    public CommonResult createCollect(@RequestBody Collection collection){
        int count=collectService.createCollect(collection);
        return CommonResultUtil.processCommonResult(count);
    }

    @GetMapping("/{collectionId}")
    public CommonResult getCollection(@PathVariable String collectionId){
        Collection collect = collectService.getCollect(collectionId);
        return CommonResult.success(collect);
    }

    @GetMapping
    public CommonResult getCollectionList(){
        List<Collection> collectionList = collectService.listCollect();
        return CommonResult.success(collectionList);
    }







}
