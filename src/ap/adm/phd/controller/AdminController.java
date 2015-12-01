package ap.adm.phd.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;

import javax.json.Json;
import javax.json.JsonObject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ap.adm.phd.AdminManager;

/*
 * @author Rounaq Jhunjhunu Wala 2014089
 * @author Ambar Pal 2014012
 */
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
		try {
			AdminManager.readRecord();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		JsonObject value = Json.createBuilderFactory(null).createObjectBuilder()
			     .add("xBoardField",String.join(",",Arrays.toString(AdminManager.temp1.toArray(new String[AdminManager.temp1.size()]))))
			     .add("xiiBoardField",String.join(",",Arrays.toString(AdminManager.temp2.toArray(new String[AdminManager.temp2.size()]))))
			     .add("graduationDegreeField",String.join(",",Arrays.toString(AdminManager.temp3.toArray(new String[AdminManager.temp3.size()]))))
			     .add("gradDeptField",String.join(",",Arrays.toString(AdminManager.temp4.toArray(new String[AdminManager.temp4.size()]))))
			     .add("pgDegreeField",String.join(",",Arrays.toString(AdminManager.temp5.toArray(new String[AdminManager.temp5.size()]))))
			     .add("pgDeptField",String.join(",",Arrays.toString(AdminManager.temp6.toArray(new String[AdminManager.temp6.size()]))))
			     .add("gradStateField",String.join(",",Arrays.toString(AdminManager.temp7.toArray(new String[AdminManager.temp7.size()]))))
			     .add("pgStateField",String.join(",",Arrays.toString(AdminManager.temp8.toArray(new String[AdminManager.temp8.size()]))))
			     .build();
		System.out.println("[AdminController GET] JSON:"+value);
		response.addCookie(new Cookie("dropdowndata",value+""));
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
    	while(params.hasMoreElements())
    	{
    		String paramName = (String)params.nextElement();
    		parameters.put(paramName,request.getParameter(paramName));
    		System.out.println("Attribute Name - "+paramName+", Value - "+request.getParameter(paramName));
    	}
    	AdminManager.filter(parameters);
    	System.out.println(AdminManager.getFilteredApplicants().size());
    	response.sendRedirect("AdminResultsController");
	}

}
