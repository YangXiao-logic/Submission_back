package com.submission.collection.entity.collection.question;

import com.submission.collection.entity.collection.FileNameRule;
import com.submission.collection.entity.collection.question.Question;

import java.util.List;

/**
 * @author YangXiao
 * @since 2022/11/22 9:58
 */
public class FileAttachmentQuestion extends Question {
    List<FileNameRule> fileNameRuleList;
}
