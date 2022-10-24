package com.submission.student.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.Date;

/**
 * @author YangXiao
 * @since 2022/10/12 21:24
 */
@Data
public class Homework {


    private String homeworkTitle;

    private String homeworkDescription;

    private Integer totalPoint;

    private Date releaseTime;

    private Date closeTime;
//    /**
//     * 教师id不需要用户输入，从token中获取
//     */
//    @JsonIgnore
//    private String teacherId;
//
//
//    private String uploadFileDirPath;


}
