package net.therap.courseenrollment.controller;

import net.therap.courseenrollment.annotation.Controller;
import net.therap.courseenrollment.model.dto.ConsoleRequest;
import net.therap.courseenrollment.model.dto.ModelAndView;
import net.therap.courseenrollment.model.entity.User;
import net.therap.courseenrollment.service.AuthService;
import net.therap.courseenrollment.service.impl.AuthServiceImpl;
import net.therap.courseenrollment.utils.Constant;

import static net.therap.courseenrollment.utils.ControllerMethodMapping.CONTROLLER_METHOD_MAP;
import static net.therap.courseenrollment.utils.ViewCode.viewsCode;

/**
 * @author rokib.ahmed
 * @since 10/24/23
 */
@Controller
public class AuthController {

    private final AuthService authService;

    public AuthController() {
        this.authService = new AuthServiceImpl();
    }

    public ModelAndView loginForm(ConsoleRequest request) {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setView(viewsCode.get(Constant.LOGIN_FORM_CODE));
        modelAndView.setModel(new User());

        return modelAndView;
    }

    public ModelAndView loginProcessing(ConsoleRequest request) {
        String login = authService.login((User) request.getBody());

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setView(viewsCode.get(Constant.INDEX));
        modelAndView.setModel(login);
        modelAndView.setControllerMethod(CONTROLLER_METHOD_MAP.get(Constant.INDEX));

        return modelAndView;
    }

    public ModelAndView registerForm(ConsoleRequest request) {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setView(viewsCode.get(Constant.REGISTER_FORM_CODE));
        modelAndView.setModel(new User());

        return modelAndView;
    }

    public ModelAndView registerProcessing(ConsoleRequest request) {
        String register = authService.register((User) request.getBody());

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setView(viewsCode.get(Constant.INDEX));
        modelAndView.setModel(register);
        modelAndView.setControllerMethod(CONTROLLER_METHOD_MAP.get(Constant.INDEX));

        return modelAndView;
    }

    public ModelAndView logout(ConsoleRequest request) {
        String logout = authService.logout();

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setView(viewsCode.get(Constant.INDEX));
        modelAndView.setModel(logout);
        modelAndView.setControllerMethod(CONTROLLER_METHOD_MAP.get(Constant.INDEX));

        return modelAndView;
    }

}
