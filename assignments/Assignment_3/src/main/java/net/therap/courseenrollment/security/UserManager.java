package net.therap.courseenrollment.security;

import net.therap.courseenrollment.model.entity.User;
import net.therap.courseenrollment.utils.Constant;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Objects;
import java.util.stream.Stream;

/**
 * @author rokib.ahmed
 * @since 10/27/23
 */
public class UserManager {

    private static StoredUser user;
    private static String filePath;

    static {
        filePath = Constant.LOGGEDIN_USER_FILE_PATH;
    }

    public static StoredUser readUserData() {
        try (Stream<String> lines = Files.lines(Paths.get(filePath))) {
            for (String line : lines.toArray(String[]::new)) {
                String[] parts = line.split(" ");

                if (parts.length == 4) {
                    String email = parts[0];
                    int loggedIn = Integer.parseInt(parts[1]);
                    String role = parts[2];
                    int id = Integer.parseInt(parts[3]);

                    return new StoredUser(id, email, loggedIn, role);
                }
            }

        } catch (Exception e) {
            e.getMessage();
        }

        return null;
    }

    public static void updateUserLoginStatus(User loggedInUser, int loggedIn) {
        user = readUserData();

        if ( Objects.nonNull(loggedInUser) && loggedIn == 1) {
            user = new StoredUser(loggedInUser.getId(), loggedInUser.getEmail(), loggedIn, loggedInUser.getRole().toString());
            saveUserData();

        } else if (Objects.nonNull(user) && loggedIn == 0) {
            clearUserDataFile();

        } else {
            System.out.println(Constant.REQUEST_TO_LOGIN);
        }

    }

    private static void saveUserData() {
        try {
            Path path = Paths.get(filePath);

            String userData = user.getEmail() + " " + user.getLoggedIn() + " " + user.getRole().toLowerCase() + " " + user.getId();

            Files.write(path, userData.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);

        } catch (IOException e) {
            e.getMessage();
        }
    }

    private static void clearUserDataFile() {
        try {
            Path path = Paths.get(filePath);

            Files.write(path, "".getBytes(), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);

        } catch (Exception e) {
            e.getMessage();
        }
    }

}
