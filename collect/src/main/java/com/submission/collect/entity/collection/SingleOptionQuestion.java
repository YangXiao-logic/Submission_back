package com.submission.collect.entity.collection;

import lombok.Data;

import java.util.List;

/**
 * @author YangXiao
 * @since 2022/11/21 15:33
 */
@Data
public class SingleOptionQuestion extends Question{
    private List<String> optionList;
}
