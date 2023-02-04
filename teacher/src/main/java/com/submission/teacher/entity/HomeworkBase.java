package com.submission.teacher.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import nonapi.io.github.classgraph.json.Id;

/**
 *
 * @author YangXiao
 */
@Data
public class HomeworkBase{

    @TableId
    @JsonIgnore
    private String homeworkId;

    private String homeworkTitle;

    private String homeworkDescription;

    private Integer totalPoint;

    private Date releaseTime;
    private Date closeTime;

    private String courseId;

    /**
     * 教师id不需要用户输入，从token中获取
     */
    @JsonIgnore
    private String teacherId;

    private String uploadFileDirPath;


//    @JsonIgnore
//    public void setUploadFileDirPath(String uploadFileDirPath) {
//        this.uploadFileDirPath = uploadFileDirPath;
//    }
}
