package com.submission.collection.entity.collection.question;

import com.submission.collection.entity.collection.Question;
import lombok.Data;

import java.util.List;

/**
 * @author YangXiao
 * @since 2023/2/8 13:21
 */
@Data
public class MultiplyChoiceQuestion extends Question {
    private List<String> optionList;
}
