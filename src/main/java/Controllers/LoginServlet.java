package Controllers;

import java.io.IOException;

import Models.UserDao;

import Security.Authentication;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {
   
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        if (Authentication.authenticate(email, password)) {
        	String username = UserDao.getUserByEmail(email);
        
            HttpSession session = request.getSession();
        	session.setAttribute("username", username);
            session.setAttribute("email",email);
            response.sendRedirect("dashboard.jsp");
            
        } else {
        	  response.sendRedirect("error.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        response.sendRedirect(request.getContextPath() + "/login.jsp");
    }
}
