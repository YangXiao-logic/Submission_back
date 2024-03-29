package com.submission.collection.entity.name;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @author YangXiao
 * @since 2023/2/5 10:15
 */
@Data
public class NameListCollection {

    @TableId
    private String nameId;
    private String name;
    private String collectionId;
}
