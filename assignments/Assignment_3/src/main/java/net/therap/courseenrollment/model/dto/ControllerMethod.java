package net.therap.courseenrollment.model.dto;

/**
 * @author rokib.ahmed
 * @since 10/30/23
 */
public class ControllerMethod {

    private Class<?> controller;
    private String method;

    public ControllerMethod(Class<?> controller, String method) {
        this.controller = controller;
        this.method = method;
    }

    public Class<?> getController() {
        return controller;
    }

    public void setController(Class<?> controller) {
        this.controller = controller;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
    
}
