package com.submission.auth.controller;

import cn.dev33.satoken.stp.SaTokenInfo;

import com.submission.auth.dto.LoginParam;
import com.submission.auth.dto.RegisterParam;
import com.submission.auth.entity.Role;
import com.submission.auth.service.AuthService;
import com.submission.common.api.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static net.sf.jsqlparser.util.validation.metadata.NamedObject.role;

/**
 * @author YangXiao
 * @since 2022/9/1 15:27
 */
@RestController
@RequestMapping("/customer")
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

    @GetMapping("/roleList/{id}")
    public CommonResult getRoleList(@PathVariable("id") String customerId){
        return CommonResult.success(authService.getRoleList(customerId));
    }

    @PostMapping("/role/{id}")
    public CommonResult createRole(@RequestBody String role){
        authService.createRole(role);
        return CommonResult.success(null,"创建身份成功");
    }

}
