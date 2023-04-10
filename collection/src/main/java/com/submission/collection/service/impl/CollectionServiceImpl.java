package com.submission.collection.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import com.submission.collection.dto.CollectionHomeResult;
import com.submission.collection.entity.collection.Collection;
import com.submission.collection.dto.CollectionDetailResult;
import com.submission.collection.entity.collection.FileRenamePattern;
import com.submission.collection.entity.collection.Question;
import com.submission.collection.entity.collection.QuestionType;
import com.submission.collection.entity.collection.question.FileAttachmentQuestion;
import com.submission.collection.entity.collection.question.NameQuestion;
import com.submission.collection.mapper.CollectionMapper;
import com.submission.collection.repository.AnswerRepository;
import com.submission.collection.repository.QuestionRepository;
import com.submission.collection.repository.SubmissionRepository;
import com.submission.collection.service.CollectionService;
import com.submission.collection.service.NameService;
import com.submission.common.exception.Asserts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author YangXiao
 * @since 2022/10/17 15:15
 */
@Service
public class CollectionServiceImpl implements CollectionService {

    @Autowired
    private CollectionMapper collectionMapper;

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private SubmissionRepository submissionRepository;

    @Autowired
    private NameService nameService;

    @Autowired
    private AnswerRepository answerRepository;

    @Override
    public int createCollection(Collection collection) {
        Snowflake snowflake = IdUtil.getSnowflake();
        List<Question> questionList = collection.getQuestionList();
        String managerId = (String) StpUtil.getLoginId();
        collection.setUserId(managerId);
        collectionMapper.insert(collection);
        String collectionId = collection.getCollectionId();

        questionList = questionList.stream().peek(question -> {
            question.setCollectionId(collectionId);
            question.setQuestionId(snowflake.nextIdStr());
        }).collect(Collectors.toList());
        List<Question> finalQuestionList = questionList;
        questionList.forEach(question -> {
            if(question instanceof FileAttachmentQuestion){
                List<FileRenamePattern> patternList =
                        ((FileAttachmentQuestion) question).getFileRenamePatternList().stream().peek((fileRenamePattern -> {
                            String tempQuestionId = fileRenamePattern.getTempQuestionId();
                            String questionId =
                                    finalQuestionList.stream()
                                            .filter(questionFindId -> Objects.equals(questionFindId.getTempQuestionId(), tempQuestionId))
                                            .findFirst().map(Question::getQuestionId).orElse("noId");
                            fileRenamePattern.setQuestionId(questionId);
                        })).collect(Collectors.toList());
                ((FileAttachmentQuestion) question).setFileRenamePatternList(patternList);
            }
        });
        questionRepository.saveAll(questionList);
        return 1;
    }

    @Override
    public Collection getCollection(String collectionId) {
        Collection collection = collectionMapper.selectById(collectionId);
//        List<Question> questionList = questionMapper.
//                selectList(new QueryWrapper<Question>().eq(collectId, "collection_id"));
        List<Question> questionList = questionRepository.findAllByCollectionId(collectionId);
        collection.setQuestionList(questionList);
        return collection;
    }

    @Override
    public List<CollectionHomeResult> getCollectionHomeResultList() {
        String managerId = (String) StpUtil.getLoginId();
        List<CollectionHomeResult> collectionHomeResults = collectionMapper.selectAllByUserId(managerId);
        collectionHomeResults = collectionHomeResults.stream().peek(collectionHomeResult -> {
            collectionHomeResult.setSubmissionCount(submissionRepository.countByCollectionId(collectionHomeResult.getCollectionId()));
            if (DateUtil.compare(collectionHomeResult.getCloseTime(), DateUtil.date()) < 0) {
                collectionHomeResult.setState(0);
            } else {
                collectionHomeResult.setState(1);
            }
        }).collect(Collectors.toList());
        return collectionHomeResults;
    }

    @Override
    @Transactional
    public int deleteCollection(String collectionId) {
        int s1 = collectionMapper.deleteById(collectionId);
        int s2 = questionRepository.deleteAllByCollectionId(collectionId);
        int s3 = submissionRepository.deleteAllByCollectionId(collectionId);
        return s1 & s2;
    }

    @Override
    public int stopCollection(String collectionId) {
        Collection collection = new Collection();
        collection.setCollectionId(collectionId);
        collection.setCloseTime(DateUtil.date());
        collectionMapper.updateById(collection);
        return 1;
    }

    @Override
    public int copyCollection(String collectionId) {
        Collection collection = getCollection(collectionId);
        collection.setCollectionId(null);
        createCollection(collection);
        return 1;
    }

    @Override
    public CollectionDetailResult getDetailCollection(String collectionId) {
        Collection collection = collectionMapper.selectById(collectionId);

        String userId = (String) StpUtil.getLoginId();
        if(!Objects.equals(userId, collection.getUserId())){
            Asserts.fail("没有访问该收集的权限");
        }

        List<Question> questionList = questionRepository.findAllByCollectionId(collectionId);

        Date closeTime = collection.getCloseTime();
        long countDown = DateUtil.between(closeTime, DateUtil.date(), DateUnit.DAY);
        int submissionCount = submissionRepository.countByCollectionId(collectionId);
        CollectionDetailResult collectionDetailResult = new CollectionDetailResult();
        collectionDetailResult.setCollectionId(collectionId);
        collectionDetailResult.setTitle(collection.getTitle());
        collectionDetailResult.setCountDown((int) countDown);
        collectionDetailResult.setSubmissionCount(submissionCount);
        collectionDetailResult.setFileCount(1);

        List<String> collectionIdList = collectionMapper.selectCollectionIdByUserId(userId);

        for (Question question : questionList) {
            if (question instanceof NameQuestion) {
                collectionDetailResult.setHasSmartName(true);
                List<String> questionIdList =
                        questionRepository.findQuestionIdsByCollectionIdInAndType(collectionIdList,
                                QuestionType.Name.getType());
                List<String> remainNameList =
                        answerRepository.findDistinctAnswerContentByQuestionIdIn(questionIdList);
                List<String> nameList = nameService.getNameListByCollectionId(collectionId);
                collectionDetailResult.setNameList(nameList);
                collectionDetailResult.setRemainNameList(remainNameList);
            } else {
                collectionDetailResult.setHasSmartName(false);
            }
        }
        return collectionDetailResult;
    }

    @Override
    public int updateCollection(Collection collection) {
        collectionMapper.updateById(collection);
        questionRepository.saveAll(collection.getQuestionList());
        return 1;
    }
}
