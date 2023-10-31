package net.therap.courseenrollment.utils;

import net.therap.courseenrollment.model.dto.ValidationError;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author rokib.ahmed
 * @since 10/28/23
 */
public class ValidationUtils {

    public static boolean isPatternMatched(String stringValue, String regexPattern) {
        Pattern pattern = Pattern.compile(regexPattern);

        Matcher matcher = pattern.matcher(stringValue);

        return matcher.matches();
    }

    public static void printError(List<ValidationError> errors) {
        System.out.println();

        for (ValidationError error : errors) {
            System.out.println(error.getFieldName() + "(" + error.getFieldType() + "): " + error.getFieldMessage());
        }

        System.out.println();
    }

}
