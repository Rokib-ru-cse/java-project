package net.therap.courseenrollment.validation;

import net.therap.courseenrollment.model.dto.ValidationError;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * @author rokib.ahmed
 * @since 10/28/23
 */
public interface Validator {

    List<ValidationError> validate(Field field, Object fieldValue) throws NoSuchMethodException,
            InvocationTargetException, InstantiationException, IllegalAccessException;

}
