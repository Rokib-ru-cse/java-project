package net.therap.validator.model.annotation;

import net.therap.validator.utils.Constant;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author rokib.ahmed
 * @since 10/19/23
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Email {

    String pattern() default Constant.VALID_EMAIL_REGEX;

    String message() default Constant.EMAIL_VALIDATION_MESSAGE;

    int min() default 5;

    Class<? extends ValueProvider> valueProvider();

}