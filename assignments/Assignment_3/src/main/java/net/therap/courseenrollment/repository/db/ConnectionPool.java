package net.therap.courseenrollment.repository.db;

import net.therap.courseenrollment.utils.Constant;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Properties;

/**
 * @author rokib.ahmed
 * @since 10/27/23
 */
public class ConnectionPool {

    private static String jdbcUrl;
    private static String userName;
    private static String password;

    private static List<Connection> connections = new ArrayList<>();
    private static int maxConnections;

    public static final Properties PROPERTIES = XMLParser.parse();

    static {
        jdbcUrl = PROPERTIES.getProperty("javax.persistence.jdbc.url");
        userName = PROPERTIES.getProperty("javax.persistence.jdbc.user");
        password = PROPERTIES.getProperty("javax.persistence.jdbc.password");

        maxConnections = Integer.parseInt(PROPERTIES.getProperty("db.max.connection.pool"));

        initializeConnections();
    }

    private static void initializeConnections() {
        try {
            for (int i = 0; i < maxConnections; i++) {
                Connection connection = DriverManager.getConnection(jdbcUrl, userName, password);
                connections.add(connection);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static synchronized Connection getConnection() {
        if (connections.isEmpty()) {
            throw new RuntimeException(Constant.NO_CONNECTION_AVAILABLE_IN_CONNECTION_POOL);
        }

        Connection connection = connections.remove(connections.size() - 1);

        try {
            if (connection.isClosed()) {
                connection = DriverManager.getConnection(jdbcUrl, userName, password);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return connection;
    }

    public static synchronized void releaseConnection(Connection connection) {
        if (Objects.nonNull(connection)) {
            try {
                if (!connection.isClosed() && connections.size() < maxConnections) {
                    connections.add(connection);

                } else {
                    connection.close();
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void close() {
        for (Connection connection : connections) {
            try {
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }

            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
