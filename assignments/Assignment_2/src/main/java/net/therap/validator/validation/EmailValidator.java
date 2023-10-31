package net.therap.validator.validation;

import net.therap.validator.model.annotation.Email;
import net.therap.validator.model.annotation.ValueProvider;
import net.therap.validator.model.validation.ValidationError;
import net.therap.validator.utils.Constant;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import static net.therap.validator.utils.ValidationUtils.isPatternMatched;

/**
 * @author rokib.ahmed
 * @since 10/22/23
 */
public class EmailValidator implements Validator {

    @Override
    public List<ValidationError> validate(Field field, Object fieldValue) throws NoSuchMethodException,
            InvocationTargetException, InstantiationException, IllegalAccessException {

        List<ValidationError> errors = new ArrayList<>();

        Email emailAnnotation = field.getAnnotation(Email.class);

        String stringValue = (String) fieldValue;

        int valueSize = emailAnnotation.valueProvider()
                .getConstructor()
                .newInstance()
                .getValue(fieldValue);

        if (valueSize < emailAnnotation.min()) {
            String message = String.format(Constant.EMAIL_LENGTH_BELOW_MIN, field.getName());
            message = message.replace("{min}", String.valueOf(emailAnnotation.min()));

            errors.add(new ValidationError(field.getName(), field.getType().getName(), message));

        }

        if (!isPatternMatched(stringValue, emailAnnotation.pattern())) {
            errors.add(new ValidationError(field.getName(), field.getType().getName(), emailAnnotation.message()));
        }

        return errors;
    }

}
