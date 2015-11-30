package ap.adm.phd.controller;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ap.adm.phd.AdminManager;

/**
 * Servlet implementation class AdminController
 */
@WebServlet("/AdminController")
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminController() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("index2.html");
		rd.include(request,response);
		return;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Enumeration<String> params = request.getParameterNames(); 
    	HashMap<String,String> parameters = new HashMap<>();
    	while(params.hasMoreElements()){
    		String paramName = (String)params.nextElement();
    		parameters.put(paramName,request.getParameter(paramName));
    		System.out.println("Attribute Name - "+paramName+", Value - "+request.getParameter(paramName));
    	}
    	try {
			AdminManager.readRecord();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
    	AdminManager.filter(parameters);
    	System.out.println(AdminManager.getFilteredApplicants().size());
	}

}
