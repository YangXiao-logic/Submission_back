package com.submission.auth.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @author YangXiao
 * @since 2022/10/5 10:42
 */
@Data
public class Role {
    String roleName;
    @TableId("role_id")
    String roleId;

    public Role(String roleName) {
        this.roleName = roleName;
    }
}
