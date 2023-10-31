package net.therap.courseenrollment.repository.crudrepo;

import java.io.Serializable;
import java.util.List;

/**
 * @author rokib.ahmed
 * @since 10/26/23
 */
public interface CrudRepository<T extends Entity, ID extends Serializable> {

    List<T> findAll();

    <S extends T> S save(S entity);

    void deleteById(ID id);

}
