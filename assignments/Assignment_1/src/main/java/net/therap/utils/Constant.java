package net.therap.utils;

/**
 * @author rokib.ahmed
 * @since 10/16/23
 */
public class Constant {

    public static final String FILE_PATH = "src/main/resources/log-parser-sample-file.log";
    public static final String SORT_ARG = "--sort";
    public static final String[] TEXT_FILE_EXTENSIONS = {"txt", "log"};
    public static final String NOT_A_TEXT_FILE_EXCEPTION_MESSAGE = "It is not a text file.";
    public static final String COMMAND_LINE_ARGS_EXCEPTION = "Usage: java LogParser <filename> [--sort]";
    public static final String REGEX_FOR_LOG_TIME = "\\d{2}:\\d{2}:\\d{2},\\d{3}";
    public static final String REGEX_FOR_LOG_ACTION_METHOD = "([GP]),\\s*time=(\\d+\\w+)";
    public static final String REGEX_FOR_LOG_URI = "URI=\\[(.*?)\\]";

}

interface Constant1 {

    String FILE_PATH = "src/main/resources/log-parser-sample-file.log";

}

enum Constant2 {

    FILE_PATH("src/main/resources/log-parser-sample-file.log");

    private final String value;

    Constant2(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

