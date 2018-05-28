package com.mercadolibre.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by jesus.leon on 27/05/18.
 */
@Target({ ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = { DnaValidator.class })
public @interface DnaInRange {
    String message() default "DNA is invalid. It must be NxN with some these letters: 'A', 'C', 'G', 'T'";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
