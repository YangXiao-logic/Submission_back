package com.submission.collect.repository;

import com.submission.collect.entity.Question;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author YangXiao
 * @since 2022/10/17 17:24
 */
@SpringBootTest
class QuestionRepositoryTest {

    @Autowired
    private QuestionRepository questionRepository;

    @Test
    void Test1(){
        questionRepository.insert(new Question());
    }

}
