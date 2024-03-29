package com.submission.collection.entity.collection;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.util.Date;
import java.util.List;

/**
 * @author YangXiao
 * @since 2022/10/15 10:47
 */
@Setter
@Getter
@JsonIgnoreProperties(allowGetters = true, value = {"collectionId"})
public class Collection {

    @TableId
    private String collectionId;

    @Null
    private String userId;
    private String collectorName;
    private String title;
    private String description;

    @NotNull
    @NotBlank
    @Future
    private Date releaseTime;
    @NotNull
    @NotBlank
    @Future
    private Date closeTime;

    @TableField(exist = false)
    private List<Question> questionList;

}
