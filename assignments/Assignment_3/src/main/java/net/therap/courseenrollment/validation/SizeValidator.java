package net.therap.courseenrollment.validation;

import net.therap.courseenrollment.annotation.Size;
import net.therap.courseenrollment.model.dto.ValidationError;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * @author rokib.ahmed
 * @since 10/28/23
 */
public class SizeValidator implements Validator {

    @Override
    public List<ValidationError> validate(Field field, Object fieldValue) {
        List<ValidationError> errors = new ArrayList<>();

        Size sizeAnnotation = field.getAnnotation(Size.class);

        int sizeValue = ((String) fieldValue).length();

        if (sizeValue < sizeAnnotation.min() || sizeValue > sizeAnnotation.max()) {
            String message = sizeAnnotation.message();

            message = message.replace("{min}", String.valueOf(sizeAnnotation.min()))
                    .replace("{max}", String.valueOf(sizeAnnotation.max()));

            errors.add(new ValidationError(field.getName(), field.getType().getName(), message));
        }

        return errors;
    }

}
