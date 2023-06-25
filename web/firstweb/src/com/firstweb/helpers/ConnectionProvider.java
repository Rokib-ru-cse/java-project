package web.firstweb.src.com.firstweb.helpers;

import java.sql.*;

public class ConnectionProvider {
    private static Connection con;

    public static Connection getConnection() {

        try {
            if (con == null) {
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javafirst", "root", "");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
}
