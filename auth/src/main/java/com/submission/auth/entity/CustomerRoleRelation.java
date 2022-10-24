package com.submission.auth.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @author YangXiao
 * @since 2022/10/5 15:53
 */
@Data
public class CustomerRoleRelation {
    @TableId(value = "id")
    String id;
    String roleId;
    String customerId;
}
