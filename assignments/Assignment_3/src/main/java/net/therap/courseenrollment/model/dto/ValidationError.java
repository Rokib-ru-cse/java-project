package net.therap.courseenrollment.model.dto;

/**
 * @author rokib.ahmed
 * @since 10/28/23
 */
public class ValidationError {

    private String fieldName;
    private String fieldType;
    private String fieldMessage;

    public ValidationError(String fieldName, String fieldType, String fieldMessage) {
        this.fieldName = fieldName;
        this.fieldType = fieldType;
        this.fieldMessage = fieldMessage;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldType() {
        return fieldType;
    }

    public void setFieldType(String fieldType) {
        this.fieldType = fieldType;
    }

    public String getFieldMessage() {
        return fieldMessage;
    }

    public void setFieldMessage(String fieldMessage) {
        this.fieldMessage = fieldMessage;
    }

}
