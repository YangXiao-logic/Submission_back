package com.submission.collect.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

/**
 * @author YangXiao
 * @since 2022/10/15 10:47
 */
@Setter
@Getter
@JsonIgnoreProperties(allowGetters = true, value = {"collectId"})
public class CollectBase {

    @TableId
    private String collectId;

    private String collectorId;
    private String collectorName;
    private String title;
    private String description;

    private Date releaseTime;
    private Date closeTime;

    @TableField(exist = false)
    private List<Question> questionList;

}
