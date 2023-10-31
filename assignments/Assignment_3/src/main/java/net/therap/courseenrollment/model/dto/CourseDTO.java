package net.therap.courseenrollment.model.dto;

/**
 * @author rokib.ahmed
 * @since 10/27/23
 */
public class CourseDTO {

    private int id;
    private String name;
    private String message;

    public CourseDTO() {
    }

    public CourseDTO(String name, String message) {
        this.name = name;
        this.message = message;
    }

    public CourseDTO(int id, String name, String message) {
        this.id = id;
        this.name = name;
        this.message = message;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
