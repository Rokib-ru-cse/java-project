package net.therap.validator.utils;

import net.therap.validator.model.annotation.Email;
import net.therap.validator.model.annotation.Password;
import net.therap.validator.model.annotation.Size;
import net.therap.validator.model.validation.ValidationError;
import net.therap.validator.validation.EmailValidator;
import net.therap.validator.validation.PasswordValidator;
import net.therap.validator.validation.SizeValidator;
import net.therap.validator.validation.Validator;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

/**
 * @author rokib.ahmed
 * @since 10/19/23
 */
public class AnnotatedValidator {

    public static Map<Class<? extends Annotation>, Validator> validatorMap = new HashMap();

    static {
        validatorMap.put(Size.class, new SizeValidator());
        validatorMap.put(Email.class, new EmailValidator());
        validatorMap.put(Password.class, new PasswordValidator());
    }

    public static List<ValidationError> validate(Object object) throws IllegalAccessException,
            InvocationTargetException, NoSuchMethodException, InstantiationException {

        List<ValidationError> errors = new ArrayList<>();

        Class<?> objectClass = object.getClass();

        Field[] declaredFields = objectClass.getDeclaredFields();

        for (Field field : declaredFields) {
            field.setAccessible(true);
            Object fieldValue = field.get(object);

            Annotation[] annotations = field.getAnnotations();

            for (Annotation annotation : annotations) {
                Class<? extends Annotation> annotationType = annotation.annotationType();
                Validator validator = validatorMap.get(annotationType);

                if (Objects.nonNull(validator)) {
                    errors.addAll(validator.validate(field, fieldValue));
                }
            }
        }
        return errors;
    }

}
