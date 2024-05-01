package Controllers;

import java.io.IOException;

import Models.UserDao;
import Models.UserModel;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
     private UserDao userDao; 
   public void init() {
	   userDao=new UserDao();
   }
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("hello...");
	    String username=request.getParameter("username");
	    String password=request.getParameter("password");
	   
	    String firstName=request.getParameter("firstName");
	    String account=request.getParameter("account");
	    String email=request.getParameter("email");
	    String lastName=request.getParameter("lastName");
	    UserModel user=new UserModel(firstName,lastName,account,email,password);
	    userDao.createUser(user);
		    response.sendRedirect(request.getContextPath() + "/dashboard.jsp?lastname=" + lastName);

	}


}
