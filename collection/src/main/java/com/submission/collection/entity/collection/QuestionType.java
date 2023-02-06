package com.submission.collection.entity.collection;

import lombok.Getter;

/**
 * @author YangXiao
 * @since 2022/11/14 11:05
 */
@Getter
public enum QuestionType {
    SingleOption("SingleOption"),
    MultiplyOption("MultiplyOption"),
    FileAttachment("FileAttachment");

    private String type;
    private QuestionType(String type){
        this.type=type;
    }

    @Override
    public String toString() {
        return this.type;
    }
}
