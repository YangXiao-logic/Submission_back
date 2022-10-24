package com.submission.teacher.service.impl;

import com.submission.teacher.entity.HomeworkBase;
import com.submission.teacher.service.HomeworkService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author YangXiao
 * @since 2022/10/8 11:05
 */
@SpringBootTest
class HomeworkServiceImplTest {

    @Autowired
    private HomeworkService homeworkService;

    @Test
    void createHomework() {
        HomeworkBase homeworkBase = new HomeworkBase();
        homeworkBase.setHomeworkTitle("homework1");
        homeworkBase.setTotalPoint(100);
        homeworkBase.setTeacherId("1");
//        HomeworkBase homework = homeworkService.createHomework(homeworkBase);
//        System.out.println(homework);
    }

    @Test
    void getHomeworkListByTeacherId() {
        for(int i=2;i<12;i++){
            HomeworkBase homeworkBase = new HomeworkBase();
            homeworkBase.setHomeworkTitle("homework"+i);
            homeworkBase.setTotalPoint(100);
            homeworkBase.setTeacherId("1");
//            HomeworkBase homework = homeworkService.createHomework(homeworkBase);
        }
        List<HomeworkBase> homeworkListByTeacherId = homeworkService.listHomework();
        System.out.println(homeworkListByTeacherId);

    }


}
