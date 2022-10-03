package com.submission.auth.controller;

import cn.dev33.satoken.stp.SaTokenInfo;

import com.submission.auth.dto.LoginParam;
import com.submission.auth.dto.RegisterParam;
import com.submission.auth.service.AuthService;
import com.submission.common.api.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author YangXiao
 * @since 2022/9/1 15:27
 */
@RestController
@RequestMapping("/auth")
public class CustomerController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public CommonResult login(@Validated @RequestBody LoginParam loginParam){
        SaTokenInfo saTokenInfo = authService.login(loginParam);
        return CommonResult.success(saTokenInfo,"登录成功");
    }

    @PostMapping("/register")
    public CommonResult register(@Validated @RequestBody RegisterParam registerParam ){
        authService.register(registerParam);
        return CommonResult.success(null,"注册成功");
    }


}
