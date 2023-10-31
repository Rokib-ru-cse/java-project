package net.therap.courseenrollment.model.dto;

/**
 * @author rokib.ahmed
 * @since 10/27/23
 */
public class EnrollmentInfo {

    private int courseId;
    private boolean isEnrolled;

    public EnrollmentInfo(int courseId, boolean isEnrolled) {
        this.courseId = courseId;
        this.isEnrolled = isEnrolled;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public boolean isEnrolled() {
        return isEnrolled;
    }

    public void setEnrolled(boolean enrolled) {
        isEnrolled = enrolled;
    }

}
