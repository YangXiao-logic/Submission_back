package com.submission.collection.entity.collection;


import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.submission.collection.entity.collection.question.*;
import com.submission.common.validation.Enum;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

/**
 * @author YangXiao
 * @since 2022/10/15 10:49
 */
@Data
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type", visible = true)
@JsonSubTypes({
        @JsonSubTypes.Type(value = SingleChoiceQuestion.class, name = "SingleChoice"),
        @JsonSubTypes.Type(value = FileAttachmentQuestion.class, name = "FileAttachment"),
        @JsonSubTypes.Type(value = SimpleTextInputQuestion.class, name = "SimpleTextInput"),
        @JsonSubTypes.Type(value = MultiplyChoiceQuestion.class, name = "MultiplyChoice"),
        @JsonSubTypes.Type(value = NameQuestion.class, name = "Name"),
})
public class Question {
    @Id
    private String questionId;
    private String collectionId;

    @Transient
    private String tempQuestionId;

    private int questionOrder;
    private String name;
    private String description;

    private boolean required;

    @Enum(enumClass = QuestionType.class)
    private QuestionType type;


}
