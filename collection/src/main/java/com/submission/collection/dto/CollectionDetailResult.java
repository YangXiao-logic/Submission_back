package com.submission.collection.dto;

import lombok.Data;

import java.util.List;

/**
 * @author YangXiao
 * @since 2023/2/9 9:08
 */
@Data
public class CollectionDetailResult {
    private String collectionId;
    private String title;

    private int submissionCount;
    private int fileCount;
    private int countDown;

    private boolean hasSmartName;

    private List<String> nameList;

    private List<String> remainNameList;

}
