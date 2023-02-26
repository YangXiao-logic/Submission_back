package com.submission.collection.controller;

import com.submission.collection.service.NameService;
import com.submission.common.api.CommonResult;
import com.submission.common.api.CommonResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author YangXiao
 * @since 2023/2/5 9:30
 */
@RestController
@RequestMapping("/collections/{collectionId}")
public class NameListController {

    @Autowired
    private NameService nameService;

    @GetMapping("/names")
    public CommonResult getCollectionNameList(@PathVariable String collectionId){
        List<String> nameList = nameService.getNameListByCollectionId(collectionId);
        return CommonResult.success(nameList);
    }

    @GetMapping("/remain-names")
    public CommonResult getRemainNameList(@PathVariable String collectionId){
        List<String> remainNameList = nameService.getRemainNameList(collectionId);
        return CommonResult.success(remainNameList);
    }

    @PostMapping("/name-list")
    public CommonResult addNameList(@PathVariable String collectionId, @RequestBody List<String> nameList){
        return CommonResultUtil.processCommonResult(nameService.addCollectionNameList(nameList,collectionId));
    }

}
