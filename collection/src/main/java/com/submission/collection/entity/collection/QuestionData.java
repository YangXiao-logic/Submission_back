package com.submission.collection.entity.collection;

import lombok.Data;
import nonapi.io.github.classgraph.json.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.redis.core.index.Indexed;

import java.util.List;

/**
 * @author YangXiao
 * @since 2022/11/21 10:09
 */
@Document
@Data
public class QuestionData {

    @Indexed
    private String questionId;
    @Id
    private String questionDataId;

    private List<String> questionData;

}
