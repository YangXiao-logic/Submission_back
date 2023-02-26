package com.submission.collection.dto;

import lombok.Data;

import java.util.Date;

/**
 * @author YangXiao
 * @since 2023/2/13 17:14
 */
@Data
public class CollectionHomeResult {
    private String collectionId;
    private String collectorName;
    private String title;
    private int submissionCount;
    private Date closeTime;
    /**
     * 0 for closed, 1 for not closed.
     */
    private int state;
}
