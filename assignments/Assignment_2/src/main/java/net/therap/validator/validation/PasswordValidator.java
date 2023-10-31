package net.therap.validator.validation;

import net.therap.validator.model.annotation.Password;
import net.therap.validator.model.validation.ValidationError;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import static net.therap.validator.utils.ValidationUtils.isPatternMatched;

/**
 * @author rokib.ahmed
 * @since 10/22/23
 */
public class PasswordValidator implements Validator {

    @Override
    public List<ValidationError> validate(Field field, Object fieldValue) {
        List<ValidationError> errors = new ArrayList<>();

        Password passwordAnnotation = field.getAnnotation(Password.class);

        String stringValue = (String) fieldValue;

        if (!isPatternMatched(stringValue, passwordAnnotation.pattern())) {
            errors.add(new ValidationError(field.getName(), field.getType().getName(), passwordAnnotation.message()));
        }

        return errors;
    }

}
