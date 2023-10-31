package net.therap.validator.controller;

import net.therap.validator.model.Employee;
import net.therap.validator.model.Status;
import net.therap.validator.model.validation.ValidationError;
import net.therap.validator.utils.AnnotatedValidator;
import net.therap.validator.view.EmployeeView;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * @author rokib.ahmed
 * @since 10/19/23
 */
public class EmployeeController {

    public static void main(String[] args) throws InvocationTargetException,
            IllegalAccessException, NoSuchMethodException, InstantiationException {

        Employee employee1 = new Employee("rokib", 27, "rokib@gmail.com", "1234", Status.GOOD);
        Employee employee2 = new Employee("rokib", 8, "rokib", "1234",Status.GOOD);

        List<ValidationError> errors1 = AnnotatedValidator.validate(employee1);

        List<ValidationError> errors2 = AnnotatedValidator.validate(employee2);

        if (!errors1.isEmpty()) {
            EmployeeView.print(errors1);
        }

        if (!errors2.isEmpty()) {
            EmployeeView.print(errors2);
        }
    }

}
