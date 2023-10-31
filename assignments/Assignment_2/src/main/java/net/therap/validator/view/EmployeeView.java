package net.therap.validator.view;

import net.therap.validator.model.validation.ValidationError;

import java.util.List;

/**
 * @author rokib.ahmed
 * @since 10/19/23
 */
public class EmployeeView {

    public static void print(List<ValidationError> errors) {
        for (ValidationError error : errors) {
            System.out.println(error.getFieldName() + "(" + error.getFieldType() + "): " + error.getFieldMessage());
        }

        System.out.println();
    }

}
