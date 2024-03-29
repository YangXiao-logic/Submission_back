package com.submission.collection.entity.collection.question;

import com.submission.collection.entity.collection.Question;
import lombok.Data;

import java.util.List;

/**
 * @author YangXiao
 * @since 2022/11/21 15:33
 */
@Data
public class SingleChoiceQuestion extends Question {
    private List<String> optionList;
}
