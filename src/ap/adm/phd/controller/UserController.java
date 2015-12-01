package ap.adm.phd.controller;

import java.io.IOException;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import ap.adm.phd.Database;
import ap.adm.phd.model.Applicant;

@WebServlet("/UserController")
@MultipartConfig
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public UserController() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	Applicant applicant = Database.newApplicant();
		request.getSession().setAttribute("applicant",applicant);
		response.addCookie(new Cookie("enrollmentNumber",applicant.getPersonalInformation().getEnrollmentNo()));
		RequestDispatcher rd = request.getRequestDispatcher("applicantForm.html");
		rd.include(request,response);
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
    	Collection<Part> uploads = request.getParts();
    	Iterator<Part> it = uploads.iterator();
    	while(it.hasNext())
    	{
    		Part t = it.next();
    		if(t.getContentType() != null)
    		if(t.getContentType().equals("application/pdf") || t.getContentType().equals("application/x-pdf"))
    		{
    			t.write(applicant.getEducationInformation().getAchievements().getCv());
    			it.next().write(applicant.getEducationInformation().getAchievements().getSop());
    			break;
    		}
    	}
        response.sendRedirect("thankyou.html");
    }
}
