package com.submission.auth.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author YangXiao
 * @since 2022/10/5 11:25
 */
@Mapper
public interface RoleMapper {
    public List<String> getRoleListByCustomerId(String customerId);

    public int insertCustomerRole(String roleName);
}
