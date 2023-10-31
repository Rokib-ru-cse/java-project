package net.therap.courseenrollment.utils;

/**
 * @author rokib.ahmed
 * @since 10/24/23
 */
public class Constant {

    public static final int EXIT_CODE = 0;
    public static final int LOGIN_FORM_CODE = 1;
    public static final int LOGIN_PROCESS_CODE = 2;
    public static final int REGISTER_FORM_CODE = 3;
    public static final int REGISTER_PROCESS_CODE = 4;
    public static final int LOGOUT_CODE = 5;
    public static final int COURSE_INDEX_CODE = 6;
    public static final int COURSE_CREATE_FORM_CODE = 7;
    public static final int COURSE_PROCESS_CODE = 8;
    public static final int INDEX = 9;

    public static final String EXIT_MESSAGE = "Enter " + EXIT_CODE + " for exit : ";
    public static final String LOGIN_MESSAGE = "Enter " + LOGIN_FORM_CODE + " for login : ";
    public static final String REGISTER_MESSAGE = "Enter " + REGISTER_FORM_CODE + " for register : ";
    public static final String LOGOUT_MESSAGE = "Enter " + LOGOUT_CODE + " for logout : ";

    public static final String COURSE_LIST_MESSAGE = "Enter " + COURSE_INDEX_CODE + " to see course list : ";
    public static final String COURSE_CREATION_MESSAGE = "Enter " + COURSE_CREATE_FORM_CODE + " to create a new course : ";

    public static final String JDBC_URL = "jdbc:postgresql://localhost:5432/courseenrollment";
    public static final String DB_USER_NAME = "postgres";
    public static final String DB_PASSWORD = "1234";
    public static final int DB_MAX_CONNECTION_POOL = 10;

    public static final String BASE_PACKAGE = "net.therap.courseenrollment";
    public static final String INSTANCE_CREATION_FAILED = "\nError creating an instance of %s\n";
    public static final String DEPENDENCY_NOT_REGISTERED_MESSAGE = "\nDependency not registered.\n";

    public static final String PROJECT_ROOT = System.getProperty("user.dir");
    public static final String DB_FILE_PATH = PROJECT_ROOT + "/src/main/java/net/therap/courseenrollment/repository/db";
    public static final String COURSE_SQL_FILE_PATH = DB_FILE_PATH + "/course.sql";
    public static final String USER_SQL_FILE_PATH = DB_FILE_PATH + "/user.sql";
    public static final String COURSE_USER_SQL_FILE_PATH = DB_FILE_PATH + "/courseuser.sql";

    public static final String LOGGEDIN_USER_FILE_PATH = PROJECT_ROOT + "/src/main/java/net/therap/courseenrollment/security" + "/user.txt";

    public static final String NO_CONNECTION_AVAILABLE_IN_CONNECTION_POOL = "\nNo connections available.\n";
    public static final String DB_CONNECTION_FAILED = "\nConnection to the PostgreSQL database failed: %s\n";

    public static final String COURSE_TABLE_NAME = "courses";
    public static final String USER_TABLE_NAME = "users";
    public static final String COURSE_USER_TABLE_NAME = "coursesusers";

    public static final String TABLE_CREATED_SUCCESSFULLY = "\nTable '%s' created successfully.\n";
    public static final String TABLE_CREATION_FAILED = "\nTable creation failed: ";

    public static final String ACCESS_DENIED = "\nAccess denied !!!.\n";
    public static final String REQUEST_FOR_VALID_CODE = "\nPlease enter valid code.\n";

    public static final String BACK_TO_LIST_MESSAGE = "\nEnter 0 to back to list.\n";

    public static final String COURSE_ENROLLMENT_SUCCESS_MESSAGE = "\nEnrollment successful\n";
    public static final String COURSE_ENROLLMENT_UNSUCCESS_MESSAGE = "\nEnrollment unSuccessful\n";
    public static final String COURSE_UNENROLLMENT_SUCCESS_MESSAGE = "\nUnEnrollment successful\n";
    public static final String COURSE_UNENROLLMENT_UNSUCCESS_MESSAGE = "\nUnEnrollment is unSuccessful\n";

    public static final String REQUEST_TO_ENTER_EMAIL = "Enter email : ";
    public static final String REQUEST_TO_ENTER_PASSWORD = "Enter password : ";
    public static final String REQUEST_TO_ENTER_CONFIRM_PASSWORD = "Enter password Again : ";
    public static final String REQUEST_TO_LOGIN = "\nPlease login first.\n";
    public static final String REQUEST_TO_ENTER_COURSE_NAME = "Enter course name : ";
    public static final String REQUEST_FOR_VALID_COURSE_CODE = "\nPlease enter valid course code.\n";


    public static final String LOGOUT_SUCCESS_MESSAGE = "\nLogout successfully.\n";
    public static final String LOGIN_SUCCESS_MESSAGE = "\nLogin successfully.\n";
    public static final String REGISTRATION_SUCCESS_MESSAGE = "\nRegister successfully.\n";
    public static final String REGISTRATION_FAILED_MESSAGE = "\nRegistration failed.\n";
    public static final String COURSE_CREATION_FAILED_MESSAGE = "Course creation failed.\n";
    public static final String CREATION_SUCCESS_MESSAGE = " Created successfully.\n";
    public static final String COURSE_DELETION_SUCCESS_MESSAGE = "\nCourse deleted successfully.\n";

    public static final String USER_NOT_FOUND_MESSAGE = "\nUser not found with email %s\n";
    public static final String USER_ALREADY_EXIST_MESSAGE = "\nUser already exist with email %s try again with another email\n";
    public static final String PASSWORD_NOT_CORRECT_MESSAGE = "\nPlease enter correct password!\n";
    public static final String PASSWORD_NOT_MATCHED_MESSAGE = "\nPassword doesn't match try again.\n";

    public static final String COURSE_LIST_HEADER = "\n\t\t\t\tAvailable Courses\n" + "--------------------------------------------------" + "\nID\t\t\t\tName\t\tAction\n";

    public static final String VALID_EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
    public static final String EMAIL_VALIDATION_MESSAGE = "Please enter a valid email address.";
    public static final String SIZE_VALIDATION_MESSAGE = "Value should be between {min} and {max}.";

    private Constant() {
    }

}

