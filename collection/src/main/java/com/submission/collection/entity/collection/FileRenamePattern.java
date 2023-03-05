package com.submission.collection.entity.collection;

import lombok.Data;
import org.springframework.data.annotation.Transient;

/**
 * @author YangXiao
 * @since 2022/11/22 10:07
 */
@Data
public class FileRenamePattern {
    private String questionId;
    @Transient
    private String tempQuestionId;
    private String patternOrder;
}
