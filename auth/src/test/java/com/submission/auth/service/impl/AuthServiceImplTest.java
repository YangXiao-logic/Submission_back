package com.submission.auth.service.impl;

import com.submission.auth.dto.RegisterParam;
import com.submission.auth.service.AuthService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author YangXiao
 * @since 2023/3/25 14:35
 */
@SpringBootTest
class AuthServiceImplTest {

    @Autowired
    private AuthService authService;

    @Test
    void register() {
        RegisterParam registerParam = new RegisterParam();
        registerParam.setMobile("17338676735");
        authService.register(registerParam);

    }

    @Test
    void loadCustomerByPhone() {
    }

    @Test
    void loadCustomerByAccount() {
    }

    @Test
    void login() {
    }



    @Test
    void getRoleList() {
    }

    @Test
    void createRole() {
    }

    @Test
    void logout() {
    }

    @Test
    void resetPassword() {
    }
}
