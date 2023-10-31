package net.therap.validator.model.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author rokib.ahmed
 * @since 10/19/23
 */
@Target({ElementType.ANNOTATION_TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Size {

    int min() default 0;

    int max() default Integer.MAX_VALUE;

    String message() default "Value should be between {min} and {max}";

    Class<? extends ValueProvider> valueProvider();

}
