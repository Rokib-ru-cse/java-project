package net.therap.courseenrollment.repository;

import net.therap.courseenrollment.model.entity.User;
import net.therap.courseenrollment.model.enums.Role;
import net.therap.courseenrollment.repository.crudrepo.Entity;
import net.therap.courseenrollment.repository.crudrepo.GenericCrudRepository;
import net.therap.courseenrollment.repository.crudrepo.QueryBuilder;
import net.therap.courseenrollment.repository.db.ConnectionPool;
import net.therap.courseenrollment.repository.repointerface.UserRepository;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;

/**
 * @author rokib.ahmed
 * @since 10/27/23
 */
public class UserRepositoryImpl<T extends Entity, ID extends Serializable>
        extends GenericCrudRepository<T, ID>
        implements UserRepository<T, ID> {

    private final Class<T> entityClass;

    public UserRepositoryImpl(Class<T> entityClass) {
        super(entityClass);
        this.entityClass = entityClass;
    }

    @Override
    public User findByEmail(String email) {
        Connection connection = ConnectionPool.getConnection();

        String tableName = null;
        try {
            T instance = entityClass.newInstance();
            tableName = instance.getTableName();
            Map<String, Object> columnValueMap = instance.getColumnValueMap();

            //columnValueMap = columnValueMap.entrySet().stream().filter(entry -> "email".equalsIgnoreCase(entry.getKey())).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (existing, replacement) -> existing));
            columnValueMap.clear();
            columnValueMap.put("email", null);

            String selectQuery = QueryBuilder.generateSelectQueryWithColumn(tableName, columnValueMap);

            PreparedStatement statement = connection.prepareStatement(selectQuery);
            statement.setObject(1, email);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String password = resultSet.getString(3);
                String role = resultSet.getString(4);

                return new User(id, email, password, Role.fromString(role));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());

        } finally {
            ConnectionPool.releaseConnection(connection);
        }

        return null;
    }

}
