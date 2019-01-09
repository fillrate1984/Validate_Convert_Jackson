package com.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Constraint(validatedBy = UniqIdValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqId {
    String message() default "Not unique Id";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
