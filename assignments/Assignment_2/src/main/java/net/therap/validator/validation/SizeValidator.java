package net.therap.validator.validation;

import net.therap.validator.model.annotation.Size;
import net.therap.validator.model.annotation.ValueProvider;
import net.therap.validator.model.validation.ValidationError;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author rokib.ahmed
 * @since 10/22/23
 */
public class SizeValidator implements Validator {

    @Override
    public List<ValidationError> validate(Field field, Object fieldValue) throws NoSuchMethodException,
            InvocationTargetException, InstantiationException, IllegalAccessException {

        List<ValidationError> errors = new ArrayList<>();

        Size sizeAnnotation = field.getAnnotation(Size.class);

        int sizeValue = sizeAnnotation.valueProvider()
                .getConstructor()
                .newInstance()
                .getValue(fieldValue);

        if (sizeValue < sizeAnnotation.min() || sizeValue > sizeAnnotation.max()) {
            String message = sizeAnnotation.message();

            message = message.replace("{min}", String.valueOf(sizeAnnotation.min()))
                    .replace("{max}", String.valueOf(sizeAnnotation.max()));

            errors.add(new ValidationError(field.getName(), field.getType().getName(), message));
        }

        return errors;
    }

}
