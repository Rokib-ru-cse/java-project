package net.therap.courseenrollment.utils;

import net.therap.courseenrollment.controller.AuthController;
import net.therap.courseenrollment.controller.CourseController;
import net.therap.courseenrollment.model.dto.ControllerMethod;
import net.therap.courseenrollment.view.Index;

import java.util.HashMap;
import java.util.Map;

/**
 * @author rokib.ahmed
 * @since 10/30/23
 */
public class ViewCode {

    public static Map<Integer, String> viewsCode = new HashMap<>();

    static {
        viewsCode.put(Constant.EXIT_CODE, null);
        viewsCode.put(Constant.INDEX, "index");

        viewsCode.put(Constant.LOGIN_FORM_CODE, "auth/login");
        viewsCode.put(Constant.REGISTER_FORM_CODE, "auth/register");
        viewsCode.put(Constant.LOGOUT_CODE, "auth/logout");

        viewsCode.put(Constant.COURSE_INDEX_CODE, "course/index");
        viewsCode.put(Constant.COURSE_CREATE_FORM_CODE, "course/create");
    }

}
