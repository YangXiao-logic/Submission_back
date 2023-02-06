package com.submission.collection.controller;

import com.submission.collection.service.NameService;
import com.submission.common.api.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author YangXiao
 * @since 2023/2/5 9:30
 */
@RestController("/collections/{collectionId}")
public class NameListController {

    @Autowired
    private NameService nameService;

    @GetMapping("/names")
    public CommonResult getCollectionNameSet(){
        return CommonResult.success(null);
    }

    @GetMapping("/remain-names")
    public CommonResult getRemainNameSet(){
        return CommonResult.success(null);
    }

    @PostMapping()
    public CommonResult getRemainNameList(){

    }

}
