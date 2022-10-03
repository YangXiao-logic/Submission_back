package com.submission.auth.service;

import cn.dev33.satoken.stp.SaTokenInfo;
import com.submission.auth.dto.LoginParam;
import com.submission.auth.dto.RegisterParam;
import com.submission.auth.entity.CustomerBase;


/**
 * @author YangXiao
 * @since 2022/9/1 15:34
 */
public interface AuthService {

    CustomerBase loadCustomerByPhone(String phone);


    SaTokenInfo login(LoginParam loginParam);

    void register(RegisterParam registerParam);

}
