package com.submission.collect.entity;

import lombok.Data;
import nonapi.io.github.classgraph.json.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.redis.core.index.Indexed;

/**
 * @author YangXiao
 * @since 2022/10/15 10:49
 */
@Data
@Document
public class Question {

    @Id
    private String questionId;

    @Indexed
    private String collectId;
    private int order;
    private String name;
    private String description;
    private String type;
    private Object questionData;

}
