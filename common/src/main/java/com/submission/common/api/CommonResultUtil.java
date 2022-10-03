package com.submission.common.api;

/**
 * @author YangXiao
 * @since 2022/9/3 11:28
 */
public  class CommonResultUtil {

    public static CommonResult processCommonResult(int count){
        CommonResult commonResult;
        if (count == 1) {
            commonResult = CommonResult.success(count);
        } else {
            commonResult = CommonResult.failed();
        }
        return commonResult;
    }
}
