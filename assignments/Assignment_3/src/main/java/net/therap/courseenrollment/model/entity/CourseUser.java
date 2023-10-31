package net.therap.courseenrollment.model.entity;

import net.therap.courseenrollment.repository.crudrepo.Entity;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import static net.therap.courseenrollment.repository.db.ConnectionPool.PROPERTIES;

/**
 * @author rokib.ahmed
 * @since 10/27/23
 */
public class CourseUser implements Serializable, Entity {

    private static final long serialVersionUID = 3L;

    private int id;
    private int courseId;
    private int userId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String getTableName() {
        return PROPERTIES.getProperty("Class.CourseUser");
    }

    @Override
    public Map<String, Object> getColumnValueMap() {
        Map<String, Object> map = new HashMap<>();

        map.put("id", id);
        map.put("course_Id", courseId);
        map.put("user_Id", userId);

        return map;
    }

}
