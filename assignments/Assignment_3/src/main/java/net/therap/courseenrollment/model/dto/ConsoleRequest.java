package net.therap.courseenrollment.model.dto;

/**
 * @author rokib.ahmed
 * @since 10/30/23
 */
public class ConsoleRequest {

    private Object body;

    public ConsoleRequest() {
    }

    public ConsoleRequest(Object body) {
        this.body = body;
    }

    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
    }

}
