package org.rcslab.validation;

import org.rcslab.validation.impl.RowColRequestValidationImpl;

import javax.validation.Constraint;
import java.lang.annotation.*;

@Documented
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy= RowColRequestValidationImpl.class)
public @interface RowColRequestValidation {
    String message() default "wrong arg";

    Class<?>[] groups() default {};

    Class<? extends javax.validation.Payload>[] payload() default {};
}
