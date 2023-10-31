package net.therap.courseenrollment.controller;

import net.therap.courseenrollment.annotation.Controller;
import net.therap.courseenrollment.model.dto.ConsoleRequest;
import net.therap.courseenrollment.model.dto.ModelAndView;
import net.therap.courseenrollment.utils.Constant;

import static net.therap.courseenrollment.utils.ViewCode.viewsCode;

/**
 * @author rokib.ahmed
 * @since 10/30/23
 */
@Controller
public class HomeController {

    public ModelAndView index(ConsoleRequest request) {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setView(viewsCode.get(Constant.INDEX));
        modelAndView.setModel(null);

        return modelAndView;
    }

    public void exit(ConsoleRequest request) {
        System.exit(0);
    }

}
