package net.therap.validator.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author rokib.ahmed
 * @since 10/19/23
 */
public class ValidationUtils {

    public static boolean isPatternMatched(String stringValue, String regexPattern) {
        Pattern pattern = Pattern.compile(regexPattern);

        Matcher matcher = pattern.matcher(stringValue);

        return matcher.matches();
    }

}
