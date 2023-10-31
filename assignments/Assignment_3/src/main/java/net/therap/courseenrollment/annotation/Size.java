package net.therap.courseenrollment.annotation;

import net.therap.courseenrollment.utils.Constant;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author rokib.ahmed
 * @since 10/28/23
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Size {

    int min() default 0;

    int max() default Integer.MAX_VALUE;

    String message() default Constant.SIZE_VALIDATION_MESSAGE;

}
