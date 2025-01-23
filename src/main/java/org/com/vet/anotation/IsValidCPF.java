package org.com.vet.anotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import org.com.vet.validator.ValidatorCPF;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ValidatorCPF.class)
public @interface IsValidCPF {
    String message () default "Invalid CPF";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
