package com.submission.teacher.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

/**
 * @author YangXiao
 * @since 2022/10/13 10:06
 */
@Data
public class ClassBase {

//    @TableId(type = IdType.ASSIGN_ID)
    @TableId
    private String classId;
    private String className;

//    @JsonIgnore
    private String teacherId;

}
