package com.submission.auth.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * @author YangXiao
 * @since 2022/9/1 15:21
 */
@Data
public class LoginParam {

    @Length(min = 11, max = 11, message = "手机号只能为11位")
    @Pattern(regexp = "^[1][3,4,5,6,7,8,9][0-9]{9}$", message = "手机号格式不对")
    String mobile;

    String account;

    @NotNull
    @NotBlank
    String password;


}
