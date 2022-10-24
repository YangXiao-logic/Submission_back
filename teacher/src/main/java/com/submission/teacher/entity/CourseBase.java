package com.submission.teacher.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

/**
 *
 * @TableName course_base
 */
@Data
public class CourseBase{

    @TableId
    private String courseId;

    private String courseName;

    private String courseDescription;

    private String classId;

    @JsonIgnore
    private String teacherId;



}
