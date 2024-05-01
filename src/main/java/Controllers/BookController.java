package Controllers;

import java.io.IOException;
import java.io.InputStream;

import Models.Book;
import Models.BookDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@MultipartConfig
public class BookController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private BookDao bookDao;

    public void init() {
        bookDao = new BookDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        Part coverPart = request.getPart("cover");
        String coverName = coverPart.getSubmittedFileName();
        InputStream cover = coverPart.getInputStream();

        String author = request.getParameter("author");
        String publisher = request.getParameter("publisher");
        String date = request.getParameter("date");
        String subject = request.getParameter("subject");

     

        Book book = new Book(name, cover, author, publisher, date, subject);
        bookDao.createBook(book);

        response.sendRedirect("dashboard.jsp");
    }
}
