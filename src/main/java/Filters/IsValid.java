package Filters;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpFilter;

public class IsValid extends HttpFilter implements Filter {

    public IsValid() {
        super();
    }

    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String password = request.getParameter("password");

        PrintWriter out = response.getWriter();
        response.setContentType("text/html");

        if (isValidEmail(email)) {
            request.setAttribute("emailMessage", "<span style='color:green;'>Email is valid.</span>");
        } else {
            request.setAttribute("emailMessage", "<span style='color:red;'>Email is invalid.</span>");
        }

        if (isValidPhone(phone)) {
            request.setAttribute("phoneMessage", "<span style='color:green;'>Phone number is valid.</span>");
        } else {
            request.setAttribute("phoneMessage", "<span style='color:red;'>Phone numbers used are from Rwanda Only.</span>");
        }

        if (isStrongPassword(password)) {
            request.setAttribute("passwordMessage", "<span style='color:green;'>Password is strong.</span>");
        } else {
            request.setAttribute("passwordMessage", "<span style='color:red;'>Password is weak.</span>");
        }
        
        chain.doFilter(request, response);
       request.getRequestDispatcher("registration.jsp").forward(request, response);

    }

    public static boolean isValidEmail(String email) {
        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static boolean isValidPhone(String phone) {
        String regex = "(07\\d{8}|250\\d{10})";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phone);
        return matcher.matches();
    }

    public static boolean isStrongPassword(String password) {
        String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }
}
