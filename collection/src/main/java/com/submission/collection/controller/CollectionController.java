package com.submission.collection.controller;

import com.submission.collection.dto.CollectionHomeResult;
import com.submission.collection.entity.collection.Collection;
import com.submission.collection.dto.CollectionDetailResult;
import com.submission.collection.entity.submission.SubmissionBrief;
import com.submission.collection.service.CollectionService;
import com.submission.collection.service.SubmissionService;
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
    private CollectionService collectionService;

    @Autowired
    private SubmissionService submissionService;

    @PostMapping
    public CommonResult createCollection(@RequestBody Collection collection){
        int count= collectionService.createCollection(collection);
        return CommonResultUtil.processCommonResult(count);
    }

    @GetMapping("/{collectionId}")
    public CommonResult getCollection(@PathVariable String collectionId){
        Collection collect = collectionService.getCollection(collectionId);
        return CommonResult.success(collect);
    }

    @PutMapping("/{collectionId}")
    public CommonResult updateCollection(@RequestBody Collection collection, @PathVariable String collectionId){
        int result = collectionService.updateCollection(collection);
        return CommonResultUtil.processCommonResult(result);
    }

    @GetMapping
    public CommonResult getCollectionList(){
        List<CollectionHomeResult> collectionList = collectionService.getCollectionHomeResultList();
        return CommonResult.success(collectionList);
    }

    @DeleteMapping("/{collectionId}")
    public CommonResult deleteCollection(@PathVariable String collectionId){
        collectionService.deleteCollection(collectionId);
        return CommonResult.success(null, "Delete Successfully");
    }

    @PostMapping("/{collectionId}/stop")
    public CommonResult stopCollection(@PathVariable String collectionId){
        collectionService.stopCollection(collectionId);
        return CommonResult.success(null, "Stop Successfully");
    }

    @GetMapping("/{collectionId}/detail")
    public CommonResult getDetailCollection(@PathVariable String collectionId){
        CollectionDetailResult collectionDetailResult = collectionService.getDetailCollection(collectionId);
        return CommonResult.success(collectionDetailResult);
    }


    @GetMapping("/{collectionId}/submissions")
    CommonResult getSubmissionList(@PathVariable String collectionId) {
        List<SubmissionBrief> submissionBriefList = submissionService.getSubmissionList(collectionId);
        return CommonResult.success(submissionBriefList);
    }

}
