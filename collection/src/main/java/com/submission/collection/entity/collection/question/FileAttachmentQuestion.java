package com.submission.collection.entity.collection.question;

import com.submission.collection.entity.collection.FileRenamePattern;
import com.submission.collection.entity.collection.Question;
import lombok.Data;

import java.util.List;

/**
 * @author YangXiao
 * @since 2022/11/22 9:58
 */
@Data
public class FileAttachmentQuestion extends Question {
    List<FileRenamePattern> fileRenamePatternList;
}
