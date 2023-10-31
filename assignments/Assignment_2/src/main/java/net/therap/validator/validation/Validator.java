package net.therap.validator.validation;

import net.therap.validator.model.validation.ValidationError;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * @author rokib.ahmed
 * @since 10/22/23
 */
public interface Validator {

    List<ValidationError> validate(Field field, Object fieldValue) throws NoSuchMethodException,
            InvocationTargetException, InstantiationException, IllegalAccessException;

}
