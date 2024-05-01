package Models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Utils.DbConnection;
public class UserDao{
	public boolean createUser(UserModel user) {
	    String query = "INSERT INTO users (firstName,lastName,account,email,password) VALUES (?,?,?, ?, ?)";
	    try (PreparedStatement ps = DbConnection.getConnection().prepareStatement(query)) {
	        ps.setString(1, user.getFirstName());
	        ps.setString(2, user.getLastName());
	        ps.setString(3, user.getAccount());
	        ps.setString(4, user.getEmail());
	        ps.setString(5,user.getPassword());
	        return ps.executeUpdate() > 0;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false;
	    }
	}
	 public static String getUserByEmail(String email) {
	        String query = "SELECT username FROM users WHERE email = ?";
	        try (PreparedStatement ps = DbConnection.getConnection().prepareStatement(query)) {
	            ps.setString(1, email);
	            ResultSet rs = ps.executeQuery();
	            if (rs.next()) {
	                return rs.getString("firstName");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return null;
	    }



}

