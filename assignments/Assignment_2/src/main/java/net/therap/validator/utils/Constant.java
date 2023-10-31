package net.therap.validator.utils;

/**
 * @author rokib.ahmed
 * @since 10/19/23
 */
public class Constant {

    public static final String PASSWORD_DEFAULT_REGEX = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
    public static final String PASSWORD_VALIDATION_MESSAGE =
            "Password must meet the following criteria:\n" +
                    "- At least 8 characters in length\n" +
                    "- Contains at least one uppercase letter (A-Z)\n" +
                    "- Contains at least one digit (0-9)\n" +
                    "- Contains at least one special character (@, $, !, %, *, ?, or &)";
    public static final String VALID_EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
    public static final String EMAIL_VALIDATION_MESSAGE =
            "Please enter a valid email address. It should match the following criteria:\n" +
                    "- Should contain the '@' symbol\n" +
                    "- Should have a domain (e.g., 'example.com') with at least 2 characters\n" +
                    "- Can contain letters (A-Z, a-z), numbers (0-9), and special characters (+, _, ., -) before the '@'";

    public static final String EMAIL_LENGTH_BELOW_MIN = "The length of the field '%s' is below the minimum allowed length of {min}.";

}
