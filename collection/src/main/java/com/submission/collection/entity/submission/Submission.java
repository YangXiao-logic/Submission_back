package com.submission.collection.entity.submission;

import lombok.Data;

import java.util.List;

/**
 * @author YangXiao
 * @since 2022/11/7 17:21
 */
@Data
public class Submission {

    String submissionId;
    String collectId;
    List<Answer> answerList;

}
