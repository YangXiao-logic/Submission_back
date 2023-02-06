package com.submission.collection.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.submission.collection.entity.collection.Collection;
import com.submission.collection.entity.collection.Question;
import com.submission.collection.mapper.CollectMapper;
import com.submission.collection.mapper.QuestionMapper;
import com.submission.collection.repository.QuestionDataRepository;
import com.submission.collection.repository.QuestionRepository;
import com.submission.collection.service.CollectService;
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
    private QuestionMapper questionMapper;
    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private QuestionDataRepository questionDataRepository;

    @Override
    public int createCollect(Collection collection) {
        List<Question> questionList = collection.getQuestionList();
        String managerId = (String) StpUtil.getLoginId();
        collection.setCollectorId(managerId);
        collectMapper.insert(collection);
        String collectionId = collection.getCollectionId();

        questionList = questionList.stream()
                .peek(question -> question.setCollectionId(collectionId))
                .collect(Collectors.toList());
        questionRepository.saveAll(questionList);
        return 1;
    }

    @Override
    public Collection getCollect(String collectId) {
        Collection collection = collectMapper.selectById(collectId);
//        List<Question> questionList = questionMapper.
//                selectList(new QueryWrapper<Question>().eq(collectId, "collection_id"));
        List<Question> questionList = questionRepository.findAllByCollectionId(collectId);
        collection.setQuestionList(questionList);
        return collection;
    }

    @Override
    public List<Collection> listCollect() {
        String managerId = (String) StpUtil.getLoginId();
        QueryWrapper<Collection> collectBaseQueryWrapper = new QueryWrapper<>();
        collectBaseQueryWrapper.eq("collector_id",managerId);
        List<Collection> collectionList = collectMapper.selectList(collectBaseQueryWrapper);
        return collectionList;
    }
}
