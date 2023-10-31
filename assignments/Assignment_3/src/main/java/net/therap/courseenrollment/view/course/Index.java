package net.therap.courseenrollment.view.course;

import net.therap.courseenrollment.model.dto.ConsoleRequest;
import net.therap.courseenrollment.model.dto.ControllerMethod;
import net.therap.courseenrollment.model.dto.CourseDTO;
import net.therap.courseenrollment.model.dto.ModelAndView;
import net.therap.courseenrollment.utils.Constant;
import net.therap.courseenrollment.view.View;

import java.util.List;

import static net.therap.courseenrollment.utils.ControllerMethodMapping.CONTROLLER_METHOD_MAP;
import static net.therap.courseenrollment.utils.ViewCode.viewsCode;

/**
 * @author rokib.ahmed
 * @since 10/30/23
 */
public class Index implements View {

    @Override
    public ModelAndView view(ConsoleRequest request) {
        List<CourseDTO> courses = (List<CourseDTO>) request.getBody();

        System.out.println(Constant.COURSE_LIST_HEADER);

        for (CourseDTO course : courses) {
            System.out.println(course.getId() + "\t\t\t\t" + course.getName() + "\t\t" + course.getMessage());
        }

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setView(viewsCode.get(Constant.INDEX));
        modelAndView.setModel(null);
        modelAndView.setControllerMethod(CONTROLLER_METHOD_MAP.get(Constant.INDEX));

        return modelAndView;
    }

}
