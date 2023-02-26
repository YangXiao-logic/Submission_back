package com.submission.collection.entity.collection.question;

import lombok.Getter;

/**
 * @author YangXiao
 * @since 2022/11/14 11:05
 */
@Getter
public enum QuestionType {
    SingleChoice("SingleChoice"),
    MultiplyChoice("MultiplyChoice"),
    FileAttachment("FileAttachment"),
    SimpleTextInput("SimpleTextInput"),
    Name("Name");
    private final String type;
    private QuestionType(String type){
        this.type=type;
    }

    @Override
    public String toString() {
        return this.type;
    }
}
