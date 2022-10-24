package com.submission.auth.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.submission.auth.entity.CustomerRoleRelation;
import com.submission.auth.entity.Role;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author YangXiao
 * @since 2022/10/5 14:21
 */
@Mapper
public interface CustomerRoleRelationDao extends BaseMapper<CustomerRoleRelation> {
}
