package net.therap.courseenrollment.service.impl;

import net.therap.courseenrollment.controller.CourseController;
import net.therap.courseenrollment.model.dto.ControllerMethod;
import net.therap.courseenrollment.model.dto.CourseDTO;
import net.therap.courseenrollment.model.entity.Course;
import net.therap.courseenrollment.model.entity.CourseUser;
import net.therap.courseenrollment.repository.CourseRerository;
import net.therap.courseenrollment.repository.CourseUserRepositoryImpl;
import net.therap.courseenrollment.repository.repointerface.CourseUserRepository;
import net.therap.courseenrollment.service.CourseService;
import net.therap.courseenrollment.utils.AuthUtils;
import net.therap.courseenrollment.utils.Constant;
import net.therap.courseenrollment.utils.EnrollmentActionMethodCodeUtils;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import static net.therap.courseenrollment.utils.ControllerMethodMapping.CONTROLLER_METHOD_MAP;

/**
 * @author rokib.ahmed
 * @since 10/26/23
 */
public class CourseServiceImpl implements CourseService {

    private final CourseRerository<Course, Integer> courseRepository;
    private final CourseUserRepository<CourseUser, Integer> courseUserRepository;

    public CourseServiceImpl() {
        courseRepository = new CourseRerository(Course.class);
        courseUserRepository = new CourseUserRepositoryImpl(CourseUser.class);
    }

    @Override
    public Course createCourse(Course course) {
        course = courseRepository.save(course);

        return course;
    }

    @Override
    public List<CourseDTO> courseList() {
        List<Course> courseList = courseRepository.findAll();

        List<CourseUser> courseUserList = courseUserRepository.findAll();

        List<CourseDTO> courseDTOList = courseList.stream().map(course -> {

            Optional<CourseUser> matchingCourseUser = courseUserList.stream().filter(courseUser -> courseUser.getCourseId() == course.getId() && courseUser.getUserId() == AuthUtils.getUserId()).findFirst();

            int courseCode = EnrollmentActionMethodCodeUtils.getCode(matchingCourseUser.isPresent(), course.getId());

            String message = "";

            if (AuthUtils.isAdmin()) {
                message = EnrollmentActionMethodCodeUtils.getDeleteMessageWithCourseCode(courseCode);
                CONTROLLER_METHOD_MAP.put(courseCode, new ControllerMethod(CourseController.class, "deleteCourse"));

            } else {
                message = EnrollmentActionMethodCodeUtils.getEnrollMessageWithCourseCode(matchingCourseUser.isPresent(), courseCode);

                if (matchingCourseUser.isPresent()) {
                    CONTROLLER_METHOD_MAP.put(courseCode, new ControllerMethod(CourseController.class, "unEnroll"));

                } else {
                    CONTROLLER_METHOD_MAP.put(courseCode, new ControllerMethod(CourseController.class, "enroll"));
                }
            }

            return new CourseDTO(course.getId(), course.getName(), message);

        }).collect(Collectors.toList());

        return courseDTOList;
    }

    @Override
    public String enroll(int encodedCourseId) {
        int courseId = EnrollmentActionMethodCodeUtils.decodeActionCode(encodedCourseId);

        CourseUser courseUser = new CourseUser();

        courseUser.setCourseId(courseId);
        courseUser.setUserId(AuthUtils.getUserId());

        CourseUser enrolledCourse = courseUserRepository.save(courseUser);

        if (enrolledCourse.getId() == 0) {
            return Constant.COURSE_ENROLLMENT_UNSUCCESS_MESSAGE;

        } else {
            return Constant.COURSE_ENROLLMENT_SUCCESS_MESSAGE;
        }
    }

    @Override
    public String unEnroll(int encodedCourseId) {
        int courseId = EnrollmentActionMethodCodeUtils.decodeActionCode(encodedCourseId);

        CourseUser courseUser = courseUserRepository.deleteByCourseIdAndUserId(courseId, AuthUtils.getUserId());

        if (Objects.isNull(courseUser)) {
            return Constant.COURSE_UNENROLLMENT_UNSUCCESS_MESSAGE;

        } else {
            return Constant.COURSE_UNENROLLMENT_SUCCESS_MESSAGE;
        }
    }

    @Override
    public String deleteCourse(int encodedCourseId) {
        int courseId = EnrollmentActionMethodCodeUtils.decodeActionCode(encodedCourseId);

        courseRepository.deleteById(courseId);

        return Constant.COURSE_DELETION_SUCCESS_MESSAGE;
    }

}
