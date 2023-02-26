package com.submission.collect.mapper;

import com.submission.collection.entity.collection.question.SingleChoiceQuestion;
import com.submission.collection.entity.collection.Question;
import com.submission.collection.mapper.QuestionMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * @author YangXiao
 * @since 2022/11/21 11:41
 */
//@SpringBootTest
class QuestionMapperTest {
    @Autowired
    private QuestionMapper questionMapper;

    @Test
    void insertQuestion(){
        Question question = new Question();
        question.setName("214");
        questionMapper.insert(question);
    }

    @Test
    void test(){
        SingleChoiceQuestion singleChoiceQuestion = new SingleChoiceQuestion();
        singleChoiceQuestion.setOptionList(new ArrayList<>());
        singleChoiceQuestion.getOptionList().add("1");
        Question question=new Question();
        question.setName("1");
        List<Question> questionList=new ArrayList<>();
        questionList.add(singleChoiceQuestion);
        questionList.add(question);
        System.out.println(questionList);
    }

}
