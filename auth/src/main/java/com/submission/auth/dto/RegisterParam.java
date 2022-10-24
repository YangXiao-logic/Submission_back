package com.submission.auth.dto;

import org.hibernate.validator.constraints.Length;
import com.submission.auth.validation.CheckEqual;
import lombok.Data;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * @author YangXiao
 * @since 2022/9/2 10:00
 */
@Data
@CheckEqual(message = "密码得一样")
public class RegisterParam {

    @NotNull
    @Length(min = 11, max = 11, message = "手机号只能为11位")
    @Pattern(regexp = "^[1][3,4,5,6,7,8,9][0-9]{9}$", message = "手机号格式不对")
    private String phone;
    @NotNull
    private String account;
    @NotNull
    @Length(min = 6,message = "密码在6位以上")
    private String password1;
    @NotNull
    @Length(min = 6,message = "密码在6位以上")
    private String password2;

}
