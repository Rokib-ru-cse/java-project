package net.therap.courseenrollment.view.auth;

import net.therap.courseenrollment.model.dto.ConsoleRequest;
import net.therap.courseenrollment.model.dto.ModelAndView;
import net.therap.courseenrollment.utils.Constant;
import net.therap.courseenrollment.view.View;

import static net.therap.courseenrollment.utils.ControllerMethodMapping.CONTROLLER_METHOD_MAP;
import static net.therap.courseenrollment.utils.ViewCode.viewsCode;

/**
 * @author rokib.ahmed
 * @since 10/30/23
 */
public class Logout implements View {

    @Override
    public ModelAndView view(ConsoleRequest request) {
        System.out.println("Logout is in progress , please wait ...");

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setView(viewsCode.get(Constant.INDEX));
        modelAndView.setModel(Constant.LOGOUT_CODE);
        modelAndView.setControllerMethod(CONTROLLER_METHOD_MAP.get(Constant.LOGOUT_CODE));

        return modelAndView;
    }

}
