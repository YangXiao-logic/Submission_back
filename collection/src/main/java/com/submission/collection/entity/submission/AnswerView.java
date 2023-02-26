package com.submission.collection.entity.submission;

import lombok.Data;

import java.util.List;

/**
 * @author YangXiao
 * @since 2023/2/9 10:37
 */
@Data
public class AnswerView {
    private String questionName;
    private List<String> answerContent;
}
