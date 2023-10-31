package net.therap.courseenrollment.model.entity;

import net.therap.courseenrollment.annotation.Email;
import net.therap.courseenrollment.annotation.EnumC;
import net.therap.courseenrollment.model.enums.Role;
import net.therap.courseenrollment.repository.crudrepo.Entity;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static net.therap.courseenrollment.repository.db.ConnectionPool.PROPERTIES;

/**
 * @author rokib.ahmed
 * @since 10/24/23
 */
public class User implements Serializable, Entity {

    private static final long serialVersionUID = 123456789L;

    private int id;

    @Email
    private String email;

    private String password;

    @EnumC(value = Role.class)
    private Role role;

    public User() {
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public User(int id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }

    public User(String email, String password, Role role) {
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public User(int id, String email, String password, Role role) {
        this.id = id;
        this.email = email;
        this.password = password;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String getTableName() {
        return PROPERTIES.getProperty("Class.User");
    }

    @Override
    public Map<String, Object> getColumnValueMap() {
        Map<String, Object> map = new HashMap<>();

        map.put("id", id);
        map.put("email", email);
        map.put("password", password);
        map.put("role", Objects.isNull(role) ? null : role.getRole());

        return map;
    }

}
