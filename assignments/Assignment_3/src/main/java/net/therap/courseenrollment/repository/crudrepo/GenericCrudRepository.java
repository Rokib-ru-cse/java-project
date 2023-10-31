package net.therap.courseenrollment.repository.crudrepo;

import net.therap.courseenrollment.repository.db.ConnectionPool;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author rokib.ahmed
 * @since 10/26/23
 */
public class GenericCrudRepository<T extends Entity, ID extends Serializable>
        implements CrudRepository<T, ID> {

    private final Class<T> entityClass;

    public GenericCrudRepository(Class<T> entityClass) {
        this.entityClass = entityClass;
    }


    @Override
    public List<T> findAll() {
        Connection connection = ConnectionPool.getConnection();

        try {
            connection.setAutoCommit(false); // Demonstration purposes only

            String tableName = entityClass.newInstance().getTableName();

            String selectQuery = QueryBuilder.generateSelectAllQuery(tableName);

            List<T> entities = new ArrayList<>();

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(selectQuery);

            connection.commit();

            while (resultSet.next()) {
                T newEntity = entityClass.getConstructor().newInstance();

                Method[] setterMethods = entityClass.getMethods();

                ResultSetMetaData metaData = resultSet.getMetaData();
                int columnCount = metaData.getColumnCount();

                for (int i = 1; i <= columnCount; i++) {
                    String columnName = metaData.getColumnName(i);
                    Object columnValue = resultSet.getObject(columnName);

                    for (Method method : setterMethods) {
                        if (method.getName().equalsIgnoreCase("set" + (columnName.replace("_", "")))) {
                            method.invoke(newEntity, columnValue);
                            break;
                        }
                    }
                }
                entities.add(newEntity);
            }

            return entities;

        } catch (Exception e) {
            try {
                if (Objects.nonNull(connection)) {
                    connection.rollback();
                }

            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }

        } finally {
            ConnectionPool.releaseConnection(connection);
        }

        return Collections.EMPTY_LIST;
    }

    @Override
    public <S extends T> S save(S entity) {
        Connection connection = ConnectionPool.getConnection();

        String tableName = entity.getTableName();
        Map<String, Object> columnValueMap = entity.getColumnValueMap();

        String insertQuery = QueryBuilder.generateInsertQuery(tableName, columnValueMap);

        try {
            connection.setAutoCommit(false); // Demonstration purposes only

            PreparedStatement statement = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);

            int parameterIndex = 1;

            for (Map.Entry entry : columnValueMap.entrySet()) {
                if (entry.getKey().equals("id")) {
                    continue;
                }

                statement.setObject(parameterIndex, entry.getValue());
                parameterIndex++;
            }
            int affectedRows = statement.executeUpdate();

            connection.commit();

            if (affectedRows == 1) {
                ResultSet generatedKeys = statement.getGeneratedKeys();

                if (generatedKeys.next()) {
                    int generatedId = generatedKeys.getInt(1);

                    entity.getClass().getMethod("setId", int.class).invoke(entity, generatedId);

                    return entity;
                }
            }

        } catch (Exception e) {
            try {
                if (Objects.nonNull(connection)) {
                    connection.rollback();
                }

            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }

        } finally {
            ConnectionPool.releaseConnection(connection);
        }

        return entity;
    }


    @Override
    public void deleteById(ID courseId) {
        Connection connection = ConnectionPool.getConnection();

        String tableName = null;
        try {
            connection.setAutoCommit(false); // Demonstration purposes only

            tableName = entityClass.newInstance().getTableName();
            Map<String, Object> columnValueMap = entityClass.newInstance().getColumnValueMap();

            columnValueMap.put("id", courseId);

            columnValueMap = columnValueMap.entrySet().stream().filter(entry -> "id".equalsIgnoreCase(entry.getKey())).collect(Collectors.toMap(entry -> entry.getKey(), entry -> entry.getValue()));

            String deleteQuery = QueryBuilder.generateDeleteQuery(tableName, columnValueMap);

            try {
                PreparedStatement statement = connection.prepareStatement(deleteQuery);

                int parameterIndex = 1;

                for (Map.Entry entry : columnValueMap.entrySet()) {
                    statement.setObject(parameterIndex, entry.getValue());
                    parameterIndex++;
                }

                int affectedRows = statement.executeUpdate();

                connection.commit();

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        } catch (Exception e) {
            try {
                if (Objects.nonNull(connection)) {
                    connection.rollback();
                }

            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }

        } finally {
            ConnectionPool.releaseConnection(connection);
        }
    }

}
