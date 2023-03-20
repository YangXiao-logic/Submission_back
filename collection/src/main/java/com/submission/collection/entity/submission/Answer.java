package com.submission.collection.entity.submission;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.index.Indexed;

import java.util.List;

/**
 * @author YangXiao
 * @since 2022/10/17 19:33
 */
@Data
public class Answer {

    @Indexed
    private String questionId;
    @Id
    private String answerId;
    @Indexed
    private String collectionId;

    private String submissionId;

    private List<String> answerContent;

}
