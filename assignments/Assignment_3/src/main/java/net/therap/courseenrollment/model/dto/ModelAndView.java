package net.therap.courseenrollment.model.dto;

/**
 * @author rokib.ahmed
 * @since 10/30/23
 */
public class ModelAndView {

    private Object view;
    private Object model;
    private ControllerMethod controllerMethod;

    public ModelAndView() {
    }

    public ModelAndView(Object view) {
        this.view = view;
    }

    public ModelAndView(Object view, Object model) {
        this.view = view;
        this.model = model;
    }

    public ModelAndView(Object view, Object model, ControllerMethod controllerMethod) {
        this.view = view;
        this.model = model;
        this.controllerMethod = controllerMethod;
    }

    public Object getView() {
        return view;
    }

    public void setView(Object view) {
        this.view = view;
    }

    public Object getModel() {
        return model;
    }

    public void setModel(Object model) {
        this.model = model;
    }

    public ControllerMethod getControllerMethod() {
        return controllerMethod;
    }

    public void setControllerMethod(ControllerMethod controllerMethod) {
        this.controllerMethod = controllerMethod;
    }

}
