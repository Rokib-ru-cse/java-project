package net.therap.courseenrollment.utils;

import net.therap.courseenrollment.model.enums.Role;
import net.therap.courseenrollment.security.StoredUser;
import net.therap.courseenrollment.security.UserManager;

import java.util.Objects;

/**
 * @author rokib.ahmed
 * @since 10/27/23
 */
public class AuthUtils {

    public static boolean isUserLoggedIn() {
        StoredUser storedUser = UserManager.readUserData();

        return Objects.isNull(storedUser) ? false : storedUser.getLoggedIn() == 0 ? false : true;
    }

    public static boolean isAdmin() {
        StoredUser storedUser = UserManager.readUserData();

        return Objects.isNull(storedUser) ? false : !storedUser.getRole().equalsIgnoreCase(Role.ADMIN.getRole()) ? false : true;
    }

    public static int getUserId() {
        StoredUser storedUser = UserManager.readUserData();

        return Objects.isNull(storedUser) ? 0 : storedUser.getId();
    }

}
