package net.therap.courseenrollment.controller;

import net.therap.courseenrollment.annotation.Controller;
import net.therap.courseenrollment.model.dto.ConsoleRequest;
import net.therap.courseenrollment.model.dto.CourseDTO;
import net.therap.courseenrollment.model.dto.ModelAndView;
import net.therap.courseenrollment.model.dto.ValidationError;
import net.therap.courseenrollment.model.entity.Course;
import net.therap.courseenrollment.service.CourseService;
import net.therap.courseenrollment.service.impl.CourseServiceImpl;
import net.therap.courseenrollment.utils.AuthUtils;
import net.therap.courseenrollment.utils.Constant;
import net.therap.courseenrollment.utils.ValidationUtils;
import net.therap.courseenrollment.validation.AnnotatedValidator;

import java.util.List;

import static net.therap.courseenrollment.utils.ControllerMethodMapping.CONTROLLER_METHOD_MAP;
import static net.therap.courseenrollment.utils.ViewCode.viewsCode;

/**
 * @author rokib.ahmed
 * @since 10/26/23
 */
@Controller
public class CourseController {

    private final CourseService courseService;

    public CourseController() {
        courseService = new CourseServiceImpl();
    }


    public ModelAndView createCourseForm(ConsoleRequest request) {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setView(viewsCode.get(Constant.COURSE_CREATE_FORM_CODE));
        modelAndView.setModel(new Course());

        return modelAndView;
    }


    public ModelAndView createCourse(ConsoleRequest request) {
        Course course = (Course) request.getBody();

        List<ValidationError> validationErrors = AnnotatedValidator.validate(course);
        if (!validationErrors.isEmpty()) {
            ValidationUtils.printError(validationErrors);

            return null;
        }

        course = courseService.createCourse(course);

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setView(viewsCode.get(Constant.INDEX));
        modelAndView.setModel(course + Constant.CREATION_SUCCESS_MESSAGE);
        modelAndView.setControllerMethod(CONTROLLER_METHOD_MAP.get(Constant.INDEX));

        return modelAndView;
    }

    public ModelAndView deleteCourse(ConsoleRequest request) {
        String response;
        if (AuthUtils.isAdmin()) {
            int encodedCourseId = (int) request.getBody();
            response = courseService.deleteCourse(encodedCourseId);

        } else {
            response = Constant.ACCESS_DENIED;
        }

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setView(viewsCode.get(Constant.INDEX));
        modelAndView.setModel(response);
        modelAndView.setControllerMethod(CONTROLLER_METHOD_MAP.get(Constant.INDEX));

        return modelAndView;
    }

    public ModelAndView courseList(ConsoleRequest request) {
        List<CourseDTO> courseList = courseService.courseList();

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setView(viewsCode.get(Constant.COURSE_INDEX_CODE));
        modelAndView.setModel(courseList);

        return modelAndView;
    }


    public ModelAndView enroll(ConsoleRequest request) {
        int encodedCourseId = (int) request.getBody();
        String response = courseService.enroll(encodedCourseId);

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setView(viewsCode.get(Constant.INDEX));
        modelAndView.setModel(response);
        modelAndView.setControllerMethod(CONTROLLER_METHOD_MAP.get(Constant.INDEX));

        return modelAndView;
    }

    public ModelAndView unEnroll(ConsoleRequest request) {
        int encodedCourseId = (int) request.getBody();
        String response = courseService.unEnroll(encodedCourseId);

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setView(viewsCode.get(Constant.INDEX));
        modelAndView.setModel(response);
        modelAndView.setControllerMethod(CONTROLLER_METHOD_MAP.get(Constant.INDEX));

        return modelAndView;
    }

}
