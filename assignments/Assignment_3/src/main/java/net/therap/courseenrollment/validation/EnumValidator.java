package net.therap.courseenrollment.validation;

import net.therap.courseenrollment.annotation.EnumC;
import net.therap.courseenrollment.model.dto.ValidationError;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * @author rokib.ahmed
 * @since 10/28/23
 */
public class EnumValidator implements Validator {

    @Override
    public List<ValidationError> validate(Field field, Object fieldValue) {
        List<ValidationError> errors = new ArrayList<>();

        EnumC enumAnnotation = field.getAnnotation(EnumC.class);

        if (enumAnnotation != null) {
            Class<?> expectedClass = enumAnnotation.value();

            if (fieldValue != null && !expectedClass.isAssignableFrom(fieldValue.getClass())) {
                errors.add(new ValidationError(
                        field.getName(), field.getType().getName(),
                        "Field does not match the expected class: " + expectedClass.getName()
                ));
            }
        }

        return errors;
    }

}
