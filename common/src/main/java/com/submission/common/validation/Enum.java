package com.submission.common.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author YangXiao
 * @since 2023/2/15 16:47
 */

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EnumValidatorImpl.class)
public @interface Enum {
    Class<? extends java.lang.Enum<?>> enumClass();

    String message() default "枚举值不合法";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}


