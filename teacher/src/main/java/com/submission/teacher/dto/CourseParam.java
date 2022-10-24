package com.submission.teacher.dto;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @author YangXiao
 * @since 2022/10/6 9:49
 */
@Data
public class CourseParam {

    @TableId
    private String courseId;

    private String courseName;

    private String courseDescription;


}
