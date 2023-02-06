package com.submission.collection.entity.collection;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;

/**
 * @author YangXiao
 * @since 2022/10/15 10:49
 */
@Data
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = SingleOptionQuestion.class, name = "SingleOption"),
        @JsonSubTypes.Type(value = FileAttachmentQuestion.class, name = "FileAttachment"),
        @JsonSubTypes.Type(value = SimpleTextInputQuestion.class, name = "SimpleTextInput")
})
public class Question {

    @TableId
    private String questionId;
    private String collectionId;

    private int questionOrder;
    private String name;
    private String description;
    private String type;

    @TableField(exist = false)
    private Object questionData;


}
