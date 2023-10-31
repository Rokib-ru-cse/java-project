package net.therap.courseenrollment.validation;

import net.therap.courseenrollment.annotation.Email;
import net.therap.courseenrollment.annotation.EnumC;
import net.therap.courseenrollment.annotation.Size;
import net.therap.courseenrollment.model.dto.ValidationError;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.*;

/**
 * @author rokib.ahmed
 * @since 10/28/23
 */
public class AnnotatedValidator {

    public static Map<Class<? extends Annotation>, Validator> validatorMap = new HashMap();

    static {
        validatorMap.put(Size.class, new SizeValidator());
        validatorMap.put(Email.class, new EmailValidator());
        validatorMap.put(EnumC.class, new EnumValidator());
    }

    public static List<ValidationError> validate(Object object) {
        List<ValidationError> errors = new ArrayList<>();

        Class<?> objectClass = object.getClass();

        Field[] declaredFields = objectClass.getDeclaredFields();

        for (Field field : declaredFields) {
            try {
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

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        return errors;
    }

}
