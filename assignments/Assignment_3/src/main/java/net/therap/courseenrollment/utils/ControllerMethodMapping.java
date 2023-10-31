package net.therap.courseenrollment.utils;

import net.therap.courseenrollment.controller.AuthController;
import net.therap.courseenrollment.controller.CourseController;
import net.therap.courseenrollment.controller.HomeController;
import net.therap.courseenrollment.model.dto.ControllerMethod;

import java.util.HashMap;
import java.util.Map;

/**
 * @author rokib.ahmed
 * @since 10/30/23
 */
public class ControllerMethodMapping {

    public static Map<Integer, ControllerMethod> CONTROLLER_METHOD_MAP = new HashMap<>();

    static {
        CONTROLLER_METHOD_MAP.put(Constant.EXIT_CODE, new ControllerMethod(HomeController.class, "exit"));
        CONTROLLER_METHOD_MAP.put(Constant.INDEX, new ControllerMethod(HomeController.class, "index"));
        CONTROLLER_METHOD_MAP.put(Constant.COURSE_INDEX_CODE, new ControllerMethod(CourseController.class, "courseList"));
        CONTROLLER_METHOD_MAP.put(Constant.COURSE_CREATE_FORM_CODE, new ControllerMethod(CourseController.class, "createCourseForm"));
        CONTROLLER_METHOD_MAP.put(Constant.COURSE_PROCESS_CODE, new ControllerMethod(CourseController.class, "createCourse"));
        CONTROLLER_METHOD_MAP.put(Constant.LOGIN_FORM_CODE, new ControllerMethod(AuthController.class, "loginForm"));
        CONTROLLER_METHOD_MAP.put(Constant.LOGIN_PROCESS_CODE, new ControllerMethod(AuthController.class, "loginProcessing"));
        CONTROLLER_METHOD_MAP.put(Constant.REGISTER_FORM_CODE, new ControllerMethod(AuthController.class, "registerForm"));
        CONTROLLER_METHOD_MAP.put(Constant.REGISTER_PROCESS_CODE, new ControllerMethod(AuthController.class, "registerProcessing"));
        CONTROLLER_METHOD_MAP.put(Constant.LOGOUT_CODE, new ControllerMethod(AuthController.class, "logout"));
    }

}
