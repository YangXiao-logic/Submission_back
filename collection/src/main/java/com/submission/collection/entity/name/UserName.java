package com.submission.collection.entity.name;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @author YangXiao
 * @since 2023/2/8 10:13
 */
@Data
public class UserName{
    @TableId
    private String id;
    private String name;
    private String userId;

}
