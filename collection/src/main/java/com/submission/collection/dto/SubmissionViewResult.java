package com.submission.collection.dto;

import lombok.Data;

import java.util.Date;

/**
 * @author YangXiao
 * @since 2023/4/26 13:50
 */
@Data
public class SubmissionViewResult {
    private String submissionId;
    private String name;
    private Date submitTime;
}
