//import java.io.IOException;
//import java.io.PrintWriter;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
//public class SearchBook extends HttpServlet {
//    private static final long serialVersionUID = 1L;
//
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        String searchQuery = request.getParameter("searchQuery");
//
//        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "username",
//                "password")) {
//            String sql = "SELECT * FROM books WHERE title LIKE ?";
//            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
//                pstmt.setString(1, "%" + searchQuery + "%");
//                try (ResultSet rs = pstmt.executeQuery()) {
//                    PrintWriter out = response.getWriter();
//                    out.println("<html><body>");
//                    out.println("<h1>Search Results:</h1>");
//                    out.println("<ul>");
//                    while (rs.next()) {
//                        String title = rs.getString("title");
//                        out.println("<li>" + title + "</li>");
//                    }
//                    out.println("</ul>");
//                    out.println("</body></html>");
//                }
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//            throw new ServletException("Database access error", e);
//        }
//    }
//}
