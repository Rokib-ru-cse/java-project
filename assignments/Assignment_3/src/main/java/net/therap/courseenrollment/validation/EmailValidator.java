package net.therap.courseenrollment.validation;

import net.therap.courseenrollment.annotation.Email;
import net.therap.courseenrollment.model.dto.ValidationError;
import net.therap.courseenrollment.utils.Constant;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import static net.therap.courseenrollment.utils.ValidationUtils.isPatternMatched;

/**
 * @author rokib.ahmed
 * @since 10/28/23
 */
public class EmailValidator implements Validator {

    @Override
    public List<ValidationError> validate(Field field, Object fieldValue) {
        List<ValidationError> errors = new ArrayList<>();

        Email emailAnnotation = field.getAnnotation(Email.class);

        String stringValue = (String) fieldValue;

        if (!isPatternMatched(stringValue, Constant.VALID_EMAIL_REGEX)) {
            errors.add(new ValidationError(field.getName(), field.getType().getName(), emailAnnotation.message()));
        }

        return errors;
    }

}
