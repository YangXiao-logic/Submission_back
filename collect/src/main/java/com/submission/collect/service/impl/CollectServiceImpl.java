package com.submission.collect.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import com.submission.collect.entity.CollectBase;
import com.submission.collect.entity.Question;
import com.submission.collect.mapper.CollectMapper;
import com.submission.collect.repository.QuestionRepository;
import com.submission.collect.service.CollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author YangXiao
 * @since 2022/10/17 15:15
 */
@Service
public class CollectServiceImpl implements CollectService {

    @Autowired
    private CollectMapper collectMapper;
    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public int createCollect(CollectBase collectBase) {
        List<Question> questionList = collectBase.getQuestionList();
        String managerId = (String) StpUtil.getLoginId();
        collectBase.setCollectorId(managerId);
        collectMapper.insert(collectBase);
        String collectId = collectBase.getCollectId();
        questionList = questionList.stream()
                .peek(question -> question.setCollectId(collectId))
                .collect(Collectors.toList());
        questionRepository.insert(questionList);
        return 1;
    }

    @Override
    public CollectBase getCollect(String collectId) {
        CollectBase collectBase = collectMapper.selectById(collectId);
        List<Question> questionList = questionRepository.findAllByCollectId(collectId);
        collectBase.setQuestionList(questionList);
        return collectBase;
    }
}
