package net.therap.courseenrollment.model.entity;

import net.therap.courseenrollment.annotation.Size;
import net.therap.courseenrollment.repository.crudrepo.Entity;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import static net.therap.courseenrollment.repository.db.ConnectionPool.PROPERTIES;

/**
 * @author rokib.ahmed
 * @since 10/26/23
 */
public class Course implements Serializable, Entity {

    private static final long serialVersionUID = 1L;

    private int id;

    @Size(min = 2, max = 20)
    private String name;

    public Course() {
    }

    public Course(int id) {
        this.id = id;
    }

    public Course(String name) {
        this.name = name;
    }

    public Course(int id, String name) {
        this.id = id;
        this.name = name;
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

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public String getTableName() {
        return PROPERTIES.getProperty("Class.Course");
    }

    @Override
    public Map<String, Object> getColumnValueMap() {
        Map<String, Object> map = new HashMap<>();

        map.put("id", id);
        map.put("name", name);

        return map;
    }

}
