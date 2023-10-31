package net.therap.courseenrollment.repository;

import net.therap.courseenrollment.model.entity.CourseUser;
import net.therap.courseenrollment.repository.crudrepo.Entity;
import net.therap.courseenrollment.repository.crudrepo.GenericCrudRepository;
import net.therap.courseenrollment.repository.crudrepo.QueryBuilder;
import net.therap.courseenrollment.repository.db.ConnectionPool;
import net.therap.courseenrollment.repository.repointerface.CourseUserRepository;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author rokib.ahmed
 * @since 10/27/23
 */
public class CourseUserRepositoryImpl<T extends Entity, ID extends Serializable>
        extends GenericCrudRepository<T, ID>
        implements CourseUserRepository<T, ID> {

    private final Class<T> entityClass;

    public CourseUserRepositoryImpl(Class entityClass) {
        super(entityClass);

        this.entityClass = entityClass;
    }

    @Override
    public CourseUser deleteByCourseIdAndUserId(int courseId, int userId) {
        Connection connection = ConnectionPool.getConnection();

        String tableName = null;
        try {
            tableName = entityClass.newInstance().getTableName();
            Map<String, Object> columnValueMap = entityClass.newInstance().getColumnValueMap();

            columnValueMap.put("course_Id", courseId);
            columnValueMap.put("user_Id", userId);

            columnValueMap = columnValueMap.entrySet()
                    .stream()
                    .filter(entry -> !"id".equalsIgnoreCase(entry.getKey()))
                    .collect(Collectors.toMap(entry -> entry.getKey(), entry -> entry.getValue()));

            String deleteQuery = QueryBuilder.generateDeleteQuery(tableName, columnValueMap);

            try {
                PreparedStatement statement = connection.prepareStatement(deleteQuery);

                int parameterIndex = 1;

                for (Map.Entry entry : columnValueMap.entrySet()) {
                    if (entry.getKey().equals("id")) {
                        continue;
                    }

                    statement.setObject(parameterIndex, entry.getValue());
                    parameterIndex++;
                }

                int affectedRows = statement.executeUpdate();

                return affectedRows == 1 ? new CourseUser() : null;

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());

        } finally {
            ConnectionPool.releaseConnection(connection);
        }

        return null;
    }

}
