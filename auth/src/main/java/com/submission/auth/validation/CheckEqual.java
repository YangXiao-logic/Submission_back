package com.submission.auth.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author YangXiao
 * @since 2022/9/2 11:22
 */
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = CheckEqualClass.class)
public @interface CheckEqual {

//    String field1() default "";
//    String field2() default "";
    String message() default "两个密码必须一样";

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
