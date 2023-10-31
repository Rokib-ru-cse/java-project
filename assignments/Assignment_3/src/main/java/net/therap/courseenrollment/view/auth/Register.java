package net.therap.courseenrollment.view.auth;

import net.therap.courseenrollment.model.dto.ConsoleRequest;
import net.therap.courseenrollment.model.dto.ModelAndView;
import net.therap.courseenrollment.model.entity.User;
import net.therap.courseenrollment.utils.Constant;
import net.therap.courseenrollment.utils.Scanner;
import net.therap.courseenrollment.view.View;

import static net.therap.courseenrollment.utils.ControllerMethodMapping.CONTROLLER_METHOD_MAP;
import static net.therap.courseenrollment.utils.ViewCode.viewsCode;

/**
 * @author rokib.ahmed
 * @since 10/30/23
 */
public class Register implements View {

    @Override
    public ModelAndView view(ConsoleRequest request) {
        System.out.print(Constant.REQUEST_TO_ENTER_EMAIL);
        String email = Scanner.getScanner().next();

        System.out.print(Constant.REQUEST_TO_ENTER_PASSWORD);
        String password = Scanner.getScanner().next();

        User user = new User(email, password);

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setView(viewsCode.get(Constant.INDEX));
        modelAndView.setModel(user);
        modelAndView.setControllerMethod(CONTROLLER_METHOD_MAP.get(Constant.REGISTER_PROCESS_CODE));

        return modelAndView;
    }

}
