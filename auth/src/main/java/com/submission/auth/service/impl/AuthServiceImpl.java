package com.submission.auth.service.impl;

import cn.dev33.satoken.secure.SaSecureUtil;
import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.submission.auth.dao.CustomerBaseDao;
import com.submission.auth.dao.CustomerRoleRelationDao;
import com.submission.auth.dto.LoginParam;
import com.submission.auth.dto.RegisterParam;
import com.submission.auth.entity.CustomerBase;
import com.submission.auth.mapper.RoleMapper;
import com.submission.auth.service.AuthService;
import com.submission.common.exception.Asserts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author YangXiao
 * @since 2022/9/1 15:40
 */
@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private CustomerBaseDao customerBaseDao;

    @Autowired
    private CustomerRoleRelationDao customerRoleRelationDao;

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public CustomerBase loadCustomerByPhone(String phone) {
        QueryWrapper<CustomerBase> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("phone",phone);
        List<CustomerBase> customerList = customerBaseDao.selectList(queryWrapper);
        if(customerList.size()==0){
            return null;
        }
        return customerList.get(0);
    }

    @Override
    public CustomerBase loadCustomerByAccount(String account) {
        QueryWrapper<CustomerBase> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("account",account);
        List<CustomerBase> customerList = customerBaseDao.selectList(queryWrapper);
        if(customerList.size()==0){
            return null;
        }
        return customerList.get(0);
    }

    @Override
    public SaTokenInfo login(LoginParam loginParam) {
        String phone = loginParam.getPhone();
        String account = loginParam.getAccount();
        String password = loginParam.getPassword();
        CustomerBase customerBase = null;
        if(phone!=null){
            customerBase = loadCustomerByPhone(phone);
        }else if(account!=null) {
            customerBase = loadCustomerByAccount(account);
        }else {
            Asserts.fail("请输入账户或手机号");
        }
        if (customerBase == null) {
            Asserts.fail("该用户不存在，请注册");
        }
        if (!SaSecureUtil.md5(password).equals(customerBase.getPassword())) {
            Asserts.fail("密码错误");
        }
        StpUtil.login(customerBase.getCustomerId());
        StpUtil.getSession().set("customerInfo",customerBase);
        SaTokenInfo saTokenInfo = StpUtil.getTokenInfo();
        return saTokenInfo;

    }

    @Override
    public void register(RegisterParam registerParam) {
        String phone = registerParam.getPhone();
        List<CustomerBase> customerBase = customerBaseDao.selectList(new QueryWrapper<CustomerBase>().eq("phone", phone));
        if (customerBase.size()!=0){
            Asserts.fail("该号码已经被注册");
        }
        String encodePassword = SaSecureUtil.md5(registerParam.getPassword1());
        CustomerBase customer = new CustomerBase();
        customer.setPassword(encodePassword);
        customer.setPhone(registerParam.getPhone());
        customer.setAccount(registerParam.getAccount());
        customerBaseDao.insert(customer);
    }


    @Override
    public List<String> getRoleList(String customerId){
        return roleMapper.getRoleListByCustomerId(customerId);
    }

    @Override
    public void createRole(String role) {
        String loginId = (String) StpUtil.getLoginId();
//        customerRoleRelationDao.insert()
    }
}
