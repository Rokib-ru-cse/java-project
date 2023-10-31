package net.therap.courseenrollment.repository.db;

import net.therap.courseenrollment.utils.Constant;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author rokib.ahmed
 * @since 10/26/23
 */
public class DBMigration {

    public static void createTables() {
        createCourseTable();
        createUserTable();
        createCourseUserTable();
    }

    private static void createCourseTable() {
        try {
            executeSql(Constant.COURSE_SQL_FILE_PATH);

            System.out.println(String.format(Constant.TABLE_CREATED_SUCCESSFULLY, Constant.COURSE_TABLE_NAME));

        } catch (SQLException | IOException e) {
            System.out.println(Constant.TABLE_CREATION_FAILED + e.getMessage());
        }
    }

    private static void createUserTable() {
        try {
            executeSql(Constant.USER_SQL_FILE_PATH);

            System.out.println(String.format(Constant.TABLE_CREATED_SUCCESSFULLY, Constant.USER_TABLE_NAME));

        } catch (SQLException | IOException e) {
            System.out.println(Constant.TABLE_CREATION_FAILED + e.getMessage());
        }
    }

    private static void createCourseUserTable() {
        try {
            executeSql(Constant.COURSE_USER_SQL_FILE_PATH);

            System.out.println(String.format(Constant.TABLE_CREATED_SUCCESSFULLY, Constant.COURSE_USER_TABLE_NAME));

        } catch (SQLException | IOException e) {
            System.out.println(Constant.TABLE_CREATION_FAILED + e.getMessage());
        }
    }

    private static void executeSql(String sqlFilePath) throws IOException, SQLException {
        Connection connection = ConnectionPool.getConnection();

        Path path = Paths.get(sqlFilePath);
        List<String> lines = Files.readAllLines(path);

        String createTableSQL = lines.stream().collect(Collectors.joining(" "));

        Statement statement = connection.createStatement();
        statement.executeUpdate(createTableSQL);

        ConnectionPool.releaseConnection(connection);
    }

}

