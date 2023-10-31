package net.therap.courseenrollment.security;

/**
 * @author rokib.ahmed
 * @since 10/27/23
 */
public class StoredUser {

    private int id;
    private String email;
    private int loggedIn;
    private String role;

    public StoredUser(String email, int loggedIn, String role) {
        this.email = email;
        this.loggedIn = loggedIn;
        this.role = role;
    }

    public StoredUser(int id, String email, int loggedIn, String role) {
        this.id = id;
        this.email = email;
        this.loggedIn = loggedIn;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(int loggedIn) {
        this.loggedIn = loggedIn;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}
