package net.therap.courseenrollment.model.enums;

/**
 * @author rokib.ahmed
 * @since 10/27/23
 */
public enum Role {

    ADMIN("admin"),
    TRAINEE("trainee");

    private String value;

    Role(String value) {
        this.value = value;
    }

    public String getRole() {
        return value;
    }

    public static Role fromString(String roleString) {
        for (Role role : Role.values()) {
            if (role.getRole().equalsIgnoreCase(roleString)) {
                return role;
            }
        }

        throw new IllegalArgumentException("Invalid role: " + roleString);
    }

}

