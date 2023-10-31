package net.therap.courseenrollment.view;

import net.therap.courseenrollment.model.dto.ConsoleRequest;
import net.therap.courseenrollment.model.dto.ControllerMethod;
import net.therap.courseenrollment.model.dto.ModelAndView;
import net.therap.courseenrollment.utils.AuthUtils;
import net.therap.courseenrollment.utils.Constant;
import net.therap.courseenrollment.utils.Scanner;

import java.util.Objects;

import static net.therap.courseenrollment.utils.ControllerMethodMapping.CONTROLLER_METHOD_MAP;
import static net.therap.courseenrollment.utils.ViewCode.viewsCode;

/**
 * @author rokib.ahmed
 * @since 10/30/23
 */
public class Index implements View {

    @Override
    public ModelAndView view(ConsoleRequest request) {

        if (AuthUtils.isUserLoggedIn()) {
            System.out.println(Constant.COURSE_LIST_MESSAGE);

            if (AuthUtils.isAdmin()) {
                System.out.println(Constant.COURSE_CREATION_MESSAGE);
            }

            System.out.println(Constant.LOGOUT_MESSAGE);
            System.out.println(Constant.EXIT_MESSAGE);

        } else {
            System.out.println(Constant.LOGIN_MESSAGE);
            System.out.println(Constant.REGISTER_MESSAGE);
            System.out.println(Constant.EXIT_MESSAGE);
        }

        int userInput = Scanner.getScanner().nextInt();
        ControllerMethod controllerMethod = CONTROLLER_METHOD_MAP.get(userInput);

        if (Objects.isNull(controllerMethod)) {
            return new ModelAndView(viewsCode.get(Constant.INDEX), userInput, CONTROLLER_METHOD_MAP.get(Constant.INDEX));

        } else {
            return new ModelAndView(viewsCode.get(userInput), userInput, CONTROLLER_METHOD_MAP.get(userInput));
        }
    }

}
