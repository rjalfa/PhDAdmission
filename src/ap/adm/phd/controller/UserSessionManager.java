package ap.adm.phd.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserSessionManager
 */
@WebServlet("/UserSessionManager")
public class UserSessionManager extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserSessionManager() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.sendRedirect("gauth.html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getSession().setAttribute("guser_name",request.getParameter("name_reg"));
		request.getSession().setAttribute("guser_email",request.getParameter("email_reg"));
		request.getSession().setAttribute("logged_in_user",true);
		response.addCookie(new Cookie("guser_name", request.getParameter("name_reg")));
  	  	response.addCookie(new Cookie("guser_email", request.getParameter("email_reg")));
  	  	response.addCookie(new Cookie("guser_corrAddress", request.getParameter("corrAddress_reg")));
  	  	response.addCookie(new Cookie("guser_mobNumber", request.getParameter("mob_reg")));
	    response.sendRedirect("UserController");
		//doGet(request, response);
	    //return;
	}

}
