package ap.adm.phd.controller;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ap.adm.phd.Database;
import ap.adm.phd.model.Applicant;

@WebServlet("/UserController")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public UserController() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	Applicant applicant = new Applicant();
		request.getSession().setAttribute("applicant",applicant);
    	response.sendRedirect("applicantForm.html");
	}

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	if(request.getSession() == null) System.out.println("[ERROR] HttpSession Object NULL");
		Applicant applicant = (Applicant) request.getSession(false).getAttribute("applicant");
    	Enumeration<String> params = request.getParameterNames(); 
    	HashMap<String,String> parameters = new HashMap<>();
    	while(params.hasMoreElements()){
    		String paramName = (String)params.nextElement();
    		parameters.put(paramName,request.getParameter(paramName));
    		System.out.println("Attribute Name - "+paramName+", Value - "+request.getParameter(paramName));
    	}
    	Database.fillUser(applicant, parameters);
	}

}
