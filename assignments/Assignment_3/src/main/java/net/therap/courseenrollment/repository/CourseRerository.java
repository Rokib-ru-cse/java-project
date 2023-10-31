package net.therap.courseenrollment.repository;

import net.therap.courseenrollment.repository.crudrepo.Entity;
import net.therap.courseenrollment.repository.crudrepo.GenericCrudRepository;

import java.io.Serializable;

/**
 * @author rokib.ahmed
 * @since 10/26/23
 */
public class CourseRerository<T extends Entity, ID extends Serializable>
        extends GenericCrudRepository<T, ID> {

    public CourseRerository(Class entityClass) {
        super(entityClass);
    }

}
