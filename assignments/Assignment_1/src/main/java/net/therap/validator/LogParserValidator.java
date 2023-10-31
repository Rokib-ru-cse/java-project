package net.therap.validator;

import net.therap.exception.CommandLineArgsException;
import net.therap.exception.NotATextFileException;
import net.therap.utils.Constant;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.util.Arrays.stream;
import static net.therap.utils.Constant.TEXT_FILE_EXTENSIONS;

/**
 * Validator for LogParser command-line arguments.
 *
 * @author rokib.ahmed
 * @since 2023-10-17
 */
public class LogParserValidator {

    public static void validateCommandLineArguments(String[] args) throws Exception {
        if (args.length < 1) {
            throw new CommandLineArgsException(Constant.COMMAND_LINE_ARGS_EXCEPTION);
        }

        String filename = args[0];
        Path path = Paths.get(filename);

        if (Files.isRegularFile(path)) {
            String fileExtension = getFileExtension(filename);

            boolean isValidLogFileExtension = stream(TEXT_FILE_EXTENSIONS)
                    .anyMatch(ext -> ext.equalsIgnoreCase(fileExtension));

            if (!isValidLogFileExtension) {
                throw new NotATextFileException(Constant.NOT_A_TEXT_FILE_EXCEPTION_MESSAGE);
            }
        }
    }

    private static String getFileExtension(String fileName) {
        int lastDotIndex = fileName.lastIndexOf(".");

        return (lastDotIndex == -1) ? "" : fileName.substring(lastDotIndex + 1);
    }

}
