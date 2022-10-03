package com.submission.auth.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.submission.auth.entity.CustomerBase;
import org.apache.ibatis.annotations.Mapper;
/**
 * (CustomerBase)表数据库访问层
 *
 * @author YangXiao
 * @since 2022-09-01 15:57:03
 */
@Mapper
public interface CustomerBaseDao extends BaseMapper<CustomerBase> {

}

