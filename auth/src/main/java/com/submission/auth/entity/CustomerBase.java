package com.submission.auth.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.Date;

/**
 * (CustomerBase)表实体类
 *
 * @author YangXiao
 * @since 2022-09-01 16:54:44
 */
@Data
public class CustomerBase {

    @TableId("customer_id")
    private String customerId;

    private String phone;

    private String password;

    private String account;


}

