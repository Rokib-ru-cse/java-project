package net.therap.courseenrollment.repository.crudrepo;

import java.util.Map;

/**
 * @author rokib.ahmed
 * @since 10/27/23
 */
public class QueryBuilder {

    public static String generateInsertQuery(String tableName, Map<String, Object> columnValueMap) {
        StringBuilder queryBuilder = new StringBuilder("INSERT INTO ");
        queryBuilder.append(tableName).append(" (");

        StringBuilder values = new StringBuilder(") VALUES (");
        boolean first = true;

        for (String columnName : columnValueMap.keySet()) {
            if (columnName.equals("id")) {
                continue;
            }
            if (!first) {
                queryBuilder.append(", ");
                values.append(", ");
            }

            queryBuilder.append(columnName);
            values.append("?");

            first = false;
        }
        values.append(")");

        queryBuilder.append(values);

        return queryBuilder.toString();
    }

    public static String generateDeleteQuery(String tableName, Map<String, Object> columnValueMap) {
        StringBuilder queryBuilder = new StringBuilder("DELETE FROM " + tableName + " WHERE ");

        boolean first = true;

        for (String columnName : columnValueMap.keySet()) {
            if (!first) {
                queryBuilder.append(" AND ");
            }

            queryBuilder.append(columnName + " = ? ");
            first = false;
        }

        return queryBuilder.toString();
    }

    public static String generateSelectAllQuery(String tableName) {
        return "SELECT * FROM " + tableName;
    }

    public static String generateSelectQueryWithColumn(String tableName, Map<String, Object> columnValueMap) {
        StringBuilder queryBuilder = new StringBuilder("SELECT * FROM " + tableName + " WHERE ");

        boolean first = true;

        for (String columnName : columnValueMap.keySet()) {
            if (!first) {
                queryBuilder.append(" AND ");
            }

            queryBuilder.append(columnName + " = ? ");
            first = false;
        }

        return queryBuilder.toString();
    }

}
