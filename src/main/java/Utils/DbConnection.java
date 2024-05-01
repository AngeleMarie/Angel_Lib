package Utils;

import java.sql.*;

public class DbConnection {
    static final String url = "jdbc:mysql://localhost:3306/library";
    static final String username = "root";
    static final String password = "";

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException("Error loading MySQL JDBC driver", e);
        }
    }

    public static void close(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
