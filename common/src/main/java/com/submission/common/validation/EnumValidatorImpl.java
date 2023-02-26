package com.submission.common.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author YangXiao
 * @since 2023/2/15 16:48
 */
public class EnumValidatorImpl implements ConstraintValidator<Enum, java.lang.Enum<?>> {
    private List<String> valueList = null;

    @Override
    public void initialize(Enum annotation) {
        valueList = Arrays.stream(annotation.enumClass().getEnumConstants())
                .map(e -> ((java.lang.Enum<?>) e).name())
                .collect(Collectors.toList());
    }

    @Override
    public boolean isValid(java.lang.Enum<?> value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }
        return valueList.contains(value.name());
    }
}

