package com.submission.collection.controller;

import com.submission.collection.service.NameService;
import com.submission.common.api.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author YangXiao
 * @since 2023/2/5 9:30
 */
@RestController("/collections/{collectionId}")
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
        nameService.getRemainNameList(collectionId);
        return CommonResult.success(null);
    }

    @PostMapping("/name-list")
    public CommonResult addNameList(@PathVariable String collectionId){
        nameService.addCollectionNameList(collectionId);
        return CommonResult.success(collectionId);
    }

}
