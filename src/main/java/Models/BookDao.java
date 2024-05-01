package Models;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Utils.DbConnection;

public class BookDao {

    public boolean createBook(Book book) {
        String query = "INSERT INTO books (name, cover, author, publisher, date, subject) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = DbConnection.getConnection().prepareStatement(query)) {
            ps.setString(1, book.getName());
            ps.setBytes(2, book.getCover());
            ps.setString(3, book.getAuthor());
            ps.setString(4, book.getPublisher());
            ps.setString(5, book.getDate());
            ps.setString(6, book.getSubject());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Other methods for retrieving books or searching books can be implemented here
}
