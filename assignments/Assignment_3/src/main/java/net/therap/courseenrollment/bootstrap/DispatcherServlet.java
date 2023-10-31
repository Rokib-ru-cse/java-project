package net.therap.courseenrollment.bootstrap;

import net.therap.courseenrollment.exception.ViewNotFoundException;
import net.therap.courseenrollment.model.dto.ConsoleRequest;
import net.therap.courseenrollment.model.dto.ControllerMethod;
import net.therap.courseenrollment.model.dto.ModelAndView;
import net.therap.courseenrollment.view.Index;
import net.therap.courseenrollment.view.View;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author rokib.ahmed
 * @since 10/24/23
 */
public class DispatcherServlet {

    public void dispatch() throws
            InstantiationException,
            IllegalAccessException,
            ViewNotFoundException,
            NoSuchMethodException,
            InvocationTargetException {

        View resolvedView = new Index();

        ModelAndView modelAndView = new ModelAndView();

        while (true) {
            modelAndView = resolvedView.view(new ConsoleRequest(modelAndView.getModel()));

            ControllerMethod controllerMethod = modelAndView.getControllerMethod();
            Class<?> controller = controllerMethod.getController();

            Method method = controller.getMethod(controllerMethod.getMethod(), ConsoleRequest.class);

            ConsoleRequest consoleRequest = new ConsoleRequest(modelAndView.getModel());

            modelAndView = (ModelAndView) method.invoke(controller.newInstance(), consoleRequest);

            String viewName = (String) modelAndView.getView();

            if (modelAndView.getModel() instanceof String) {
                System.out.println(modelAndView.getModel());
            }

            resolvedView = ViewResolver.resolve(viewName);
        }
    }

}