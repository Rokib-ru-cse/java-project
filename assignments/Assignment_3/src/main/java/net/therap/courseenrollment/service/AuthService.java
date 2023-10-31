package net.therap.courseenrollment.service;

import net.therap.courseenrollment.model.entity.User;

/**
 * @author rokib.ahmed
 * @since 10/24/23
 */
public interface AuthService {
    String login(User user);

    String logout();

    String register(User user);
}
