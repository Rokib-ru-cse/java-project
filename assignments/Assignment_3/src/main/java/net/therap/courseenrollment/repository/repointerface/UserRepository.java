package net.therap.courseenrollment.repository.repointerface;

import net.therap.courseenrollment.model.entity.User;
import net.therap.courseenrollment.repository.crudrepo.CrudRepository;
import net.therap.courseenrollment.repository.crudrepo.Entity;

import java.io.Serializable;

/**
 * @author rokib.ahmed
 * @since 10/27/23
 */
public interface UserRepository<T extends Entity, ID extends Serializable>
        extends CrudRepository<T, ID> {

    User findByEmail(String email);

}
