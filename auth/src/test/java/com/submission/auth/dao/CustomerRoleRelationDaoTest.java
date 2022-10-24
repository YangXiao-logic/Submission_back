package com.submission.auth.dao;

import com.submission.auth.entity.Role;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author YangXiao
 * @since 2022/10/5 14:22
 */
@SpringBootTest
class CustomerRoleRelationDaoTest {

    @Autowired
    private CustomerRoleRelationDao customerRoleRelationDao;

    @Test
    void insertRole(){
//        customerRoleRelationDao.insert(new Role("teacher"));
//        customerRoleRelationDao.insert(new Role("student"));
    }

}
