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
public @interface Password {

    String pattern() default Constant.PASSWORD_DEFAULT_REGEX;

    String message() default Constant.PASSWORD_VALIDATION_MESSAGE;

    Class<? extends ValueProvider> valueProvider();

}
