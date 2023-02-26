package com.submission.auth.service;

import cn.dev33.satoken.stp.SaTokenInfo;
import com.submission.auth.dto.LoginParam;
import com.submission.auth.dto.RegisterParam;
import com.submission.auth.entity.CustomerBase;

import java.util.List;


/**
 * @author YangXiao
 * @since 2022/9/1 15:34
 */
public interface AuthService {

    CustomerBase loadCustomerByPhone(String phone);


    CustomerBase loadCustomerByAccount(String account);

    SaTokenInfo login(LoginParam loginParam);

    void register(RegisterParam registerParam);

    List<String> getRoleList(String customerId);

    void createRole(String role);

    void logout();
}
