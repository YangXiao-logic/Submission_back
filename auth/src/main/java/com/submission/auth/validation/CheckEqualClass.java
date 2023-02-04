package com.submission.auth.validation;


import com.submission.auth.dto.RegisterParam;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Objects;

/**
 * @author YangXiao
 * @since 2022/9/2 11:34
 */
public class CheckEqualClass implements ConstraintValidator<CheckEqual, RegisterParam> {

    private String field1;
    private String field2;

    @Override
    public void initialize(CheckEqual checkEqual) {
//        this.field1=checkEqual.field1();
//        this.field2=checkEqual.field2();
    }

    @Override
    public boolean isValid(RegisterParam registerParam, ConstraintValidatorContext constraintValidatorContext) {
//        String password1 = registerParam.getPassword1();
//        String password2 = registerParam.getPassword2();
//        return Objects.equals(password1, password2);
        return true;
    }
}
