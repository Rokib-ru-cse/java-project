package net.therap.courseenrollment.repository.repointerface;

import net.therap.courseenrollment.model.entity.CourseUser;
import net.therap.courseenrollment.repository.crudrepo.CrudRepository;
import net.therap.courseenrollment.repository.crudrepo.Entity;

import java.io.Serializable;

/**
 * @author rokib.ahmed
 * @since 10/27/23
 */
public interface CourseUserRepository<T extends Entity, ID extends Serializable>
        extends CrudRepository<T, ID> {

    CourseUser deleteByCourseIdAndUserId(int courseId, int userId);

}
