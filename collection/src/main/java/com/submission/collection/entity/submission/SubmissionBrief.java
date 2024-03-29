package com.submission.collection.entity.submission;

import lombok.Data;

import java.util.Date;

/**
 * @author YangXiao
 * @since 2023/2/9 9:44
 */
@Data
public class SubmissionBrief {
    private String submissionId;
    private String collectionId;
    private Date submitTime;
}
