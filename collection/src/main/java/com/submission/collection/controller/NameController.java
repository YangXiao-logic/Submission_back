package com.submission.collection.controller;

import com.submission.collection.entity.collection.Collection;
import com.submission.collection.service.NameService;
import com.submission.common.api.CommonResult;
import com.submission.common.api.CommonResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author YangXiao
 * @since 2023/4/25 21:23
 */
@RestController
@RequestMapping("/collections/{collectionId}/name")
public class NameController {

    @Autowired
    private NameService nameService;


    @PostMapping("/add-list")
    public CommonResult addNameList(@PathVariable String collectionId, @RequestBody List<String> nameList){
        int result = nameService.addNameList(nameList, collectionId);
        return CommonResultUtil.processCommonResult(result);
    }

    @PostMapping("/add")
    public CommonResult addName(@PathVariable String collectionId, @RequestBody String name){
        int result = nameService.addName(collectionId, name);
        return CommonResultUtil.processCommonResult(result);
    }

    @PostMapping("/delete")
    public CommonResult deleteName(@PathVariable String collectionId, @RequestBody String name){
        int result = nameService.deleteName(collectionId, name);
        return CommonResultUtil.processCommonResult(result);
    }


}
