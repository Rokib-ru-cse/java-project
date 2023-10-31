package net.therap.courseenrollment.service;

import net.therap.courseenrollment.model.dto.CourseDTO;
import net.therap.courseenrollment.model.entity.Course;

import java.util.List;

/**
 * @author rokib.ahmed
 * @since 10/26/23
 */
public interface CourseService {

    Course createCourse(Course course);

    List<CourseDTO> courseList();

    String enroll(int encodedCourseId);

    String unEnroll(int encodedCourseId);

    String deleteCourse(int encodedCourseId);

}
