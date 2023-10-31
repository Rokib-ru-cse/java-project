package net.therap.courseenrollment.service.impl;

import net.therap.courseenrollment.model.dto.ValidationError;
import net.therap.courseenrollment.model.entity.User;
import net.therap.courseenrollment.model.enums.Role;
import net.therap.courseenrollment.repository.UserRepositoryImpl;
import net.therap.courseenrollment.security.UserManager;
import net.therap.courseenrollment.service.AuthService;
import net.therap.courseenrollment.utils.Constant;
import net.therap.courseenrollment.utils.Scanner;
import net.therap.courseenrollment.utils.ValidationUtils;
import net.therap.courseenrollment.validation.AnnotatedValidator;

import java.util.List;
import java.util.Objects;

/**
 * @author rokib.ahmed
 * @since 10/24/23
 */
public class AuthServiceImpl implements AuthService {

    private final UserRepositoryImpl<User, Integer> userRepository;

    public AuthServiceImpl() {
        this.userRepository = new UserRepositoryImpl<>(User.class);
    }

    @Override
    public String login(User user) {
        User userByEmail = userRepository.findByEmail(user.getEmail());

        if (Objects.isNull(userByEmail)) {
            return String.format(Constant.USER_NOT_FOUND_MESSAGE, user.getEmail());
        }
        if (!userByEmail.getPassword().equals(user.getPassword())) {
            return Constant.PASSWORD_NOT_CORRECT_MESSAGE;
        }

        UserManager.updateUserLoginStatus(userByEmail, 1);

        return Constant.LOGIN_SUCCESS_MESSAGE;
    }

    @Override
    public String logout() {
        UserManager.updateUserLoginStatus(null, 0);

        return Constant.LOGOUT_SUCCESS_MESSAGE;
    }

    @Override
    public String register(User user) {
        User userByEmail = userRepository.findByEmail(user.getEmail());

        if (Objects.nonNull(userByEmail)) {
            return String.format(Constant.USER_ALREADY_EXIST_MESSAGE, user.getEmail());
        }

        user.setRole(Role.TRAINEE);

        List<ValidationError> validationErrors = AnnotatedValidator.validate(user);

        if (validationErrors.isEmpty()) {
            User register = userRepository.save(user);

            UserManager.updateUserLoginStatus(register, 1);

            return Constant.REGISTRATION_SUCCESS_MESSAGE;

        } else {
            ValidationUtils.printError(validationErrors);

            return Constant.REGISTRATION_FAILED_MESSAGE;
        }
    }

}
