package com.submission.collection.entity.collection.question;

import com.submission.collection.entity.collection.FileRenameRule;
import com.submission.collection.entity.collection.Question;

import java.util.List;

/**
 * @author YangXiao
 * @since 2022/11/22 9:58
 */
public class FileAttachmentQuestion extends Question {
    List<FileRenameRule> fileRenameRuleList;
}
