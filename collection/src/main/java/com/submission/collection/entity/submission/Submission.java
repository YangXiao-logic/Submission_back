package com.submission.collection.entity.submission;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.index.Indexed;

import java.util.List;

/**
 * @author YangXiao
 * @since 2022/11/7 17:21
 */
@Data
public class Submission {

    @Id
    String submissionId;
    @Indexed
    String collectionId;
    List<Answer> answerList;

}
