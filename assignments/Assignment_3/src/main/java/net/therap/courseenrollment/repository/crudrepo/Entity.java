package net.therap.courseenrollment.repository.crudrepo;

import java.util.Map;

/**
 * @author rokib.ahmed
 * @since 10/27/23
 */
public interface Entity {

    String getTableName();

    Map<String, Object> getColumnValueMap();

}
