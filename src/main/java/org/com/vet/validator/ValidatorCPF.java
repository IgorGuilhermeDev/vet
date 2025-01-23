package org.com.vet.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.com.vet.anotation.IsValidCPF;
import org.com.vet.utility.ValidationCPF;

public class ValidatorCPF implements ConstraintValidator<IsValidCPF,String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return ValidationCPF.isValidCPF(value);
    }

}
