package net.therap.validator.model;

import net.therap.validator.model.annotation.*;

/**
 * @author rokib.ahmed
 * @since 10/19/23
 */
public class Employee {

    @Size(min = 10, max = 50, valueProvider = StringValueProvider.class, message = "Value should be between {min} and {max}")
    private String name;

    @Size(min = 10, valueProvider = IntegerValueProvider.class)
    private int age;

    @Email(min = 10, valueProvider = StringValueProvider.class)
    private String email;

    @Password(valueProvider = StringValueProvider.class)
    private String password;

    @Size(min = 1, max = 2, valueProvider = EnumValueProvider.class, message = "Value should be between {min} and {max}")
    private Status status;

    public Employee(String name, int age, String email, String password) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.password = password;
    }

    public Employee(String name, int age, String email, String password, Status status) {
        this(name, age, email, password);
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
