//package Controllers;
//import java.io.IOException;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//import java.util.List;
//
//import Models.Book;
//import Models.BookDao;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
//@WebServlet("/view-Book")
//public class ViewBookServlet extends HttpServlet {
//
//    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/library";
//    private static final String JDBC_USER = "root";
//    private static final String JDBC_PASSWORD = "";
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        try {
//            Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
//            BookDao BookDao = new BookDao(connection);
//            List<Book> Book = BookDao.getAllBook();
//
//            request.setAttribute("Book", Book);
//            request.getRequestDispatcher("dashboard.jsp").forward(request, response);
//
//            connection.close();
//        } catch (SQLException e) {
//            throw new ServletException("Error fetching Book from database", e);
//        }
//    }
//}
