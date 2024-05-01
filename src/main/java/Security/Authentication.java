package Security;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Utils.DbConnection;
import jakarta.servlet.http.HttpSession;

public class Authentication {
    public static boolean authenticate(String email, String password) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DbConnection.getConnection();
            String query = "SELECT * FROM users WHERE email = ? AND password = ?";
            ps = conn.prepareStatement(query);
            ps.setString(1, email);
            ps.setString(2, password);
            rs = ps.executeQuery();
            return rs.next(); // Return true if a row is found (valid credentials)
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            // Close resources
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void setLoggedIn(HttpSession session, String email) {
        session.setAttribute("email", email);
    }

    public static void logout(HttpSession session) {
        session.invalidate();
    }

    public static boolean isLoggedIn(HttpSession session) {
        return session.getAttribute("email") != null;
    }
}
