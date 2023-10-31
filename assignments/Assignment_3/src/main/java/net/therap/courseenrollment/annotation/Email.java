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
public @interface Email {

    String message() default Constant.EMAIL_VALIDATION_MESSAGE;

}
