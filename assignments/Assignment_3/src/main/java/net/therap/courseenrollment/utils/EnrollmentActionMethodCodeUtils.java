package net.therap.courseenrollment.utils;

import net.therap.courseenrollment.model.dto.EnrollmentInfo;

/**
 * @author rokib.ahmed
 * @since 10/27/23
 */
public class EnrollmentActionMethodCodeUtils {

    public static int getCode(boolean isEnrolled, int id) {
        return createActionCode(isEnrolled, id);
    }

    public static String getEnrollMessageWithCourseCode(boolean isEnrolled, int code) {
        String enrollmentText = isEnrolled ? "UnEnroll" : "Enroll";
        String text = "Enter " + code + " to " + enrollmentText;

        return text;
    }

    public static int createActionCode(boolean isEnrolled, int id) {
        int value = isEnrolled ? (id * 200) : (id * 200 + 1);

        return value;
    }

    public static int decodeActionCode(int actionCode) {
        int id = actionCode / 200;

        return id;
    }

    public static String getDeleteMessageWithCourseCode(int courseCode) {
        String text = "Enter " + courseCode + " to delete";

        return text;
    }

}
