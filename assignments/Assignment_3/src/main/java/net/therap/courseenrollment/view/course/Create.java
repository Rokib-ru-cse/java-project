package net.therap.courseenrollment.view.course;

import net.therap.courseenrollment.model.dto.ConsoleRequest;
import net.therap.courseenrollment.model.dto.ModelAndView;
import net.therap.courseenrollment.model.entity.Course;
import net.therap.courseenrollment.utils.Constant;
import net.therap.courseenrollment.utils.Scanner;
import net.therap.courseenrollment.view.View;

import static net.therap.courseenrollment.utils.ControllerMethodMapping.CONTROLLER_METHOD_MAP;
import static net.therap.courseenrollment.utils.ViewCode.viewsCode;

/**
 * @author rokib.ahmed
 * @since 10/30/23
 */
public class Create implements View {

    @Override
    public ModelAndView view(ConsoleRequest request) {
        System.out.print(Constant.REQUEST_TO_ENTER_COURSE_NAME);

        Course course = new Course(Scanner.getScanner().next());

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setView(viewsCode.get(Constant.COURSE_PROCESS_CODE));
        modelAndView.setModel(course);
        modelAndView.setControllerMethod(CONTROLLER_METHOD_MAP.get(Constant.COURSE_PROCESS_CODE));

        return modelAndView;
    }

}
