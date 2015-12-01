package ap.adm.phd.controller;

import java.io.IOException;
import java.nio.file.FileSystem;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ap.adm.phd.AdminManager;
import ap.adm.phd.model.Applicant;

/*
 * @author Rounaq Jhunjhunu Wala 2014089
 * @author Ambar Pal 2014012
 */
/**
 * Servlet implementation class AdminResultsController
 */
@WebServlet("/AdminResultsController")
public class AdminResultsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminResultsController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().println("<!DOCTYPE html><html><head>    <title>IIITD PhD Admission Portal</title>    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, maximum-scale=1\">    <link rel=\"stylesheet\" href=\"css/bootstrap.min.css\">    <link rel=\"stylesheet\" href=\"css/material-fullpalette.min.css\">    <link rel=\"stylesheet\" href=\"css/ripples.min.css\">    <link rel=\"stylesheet\" href=\"css/roboto.min.css\">    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css\">    <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/bootstrap-social/4.10.1/bootstrap-social.min.css\">    <link href=\"https://fonts.googleapis.com/icon?family=Material+Icons\" rel=\"stylesheet\"></head><body style=\"padding-top:80px;height: 100%;overflow: scroll;\">    <div class=\"navbar navbar-inverse navbar-fixed-top\">        <div class=\"navbar-header pull-right\">            <button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\" data-target=\".navbar-responsive-collapse\">                <span class=\"icon-bar\"></span>                <span class=\"icon-bar\"></span>                <span class=\"icon-bar\"></span>            </button>            <ul class=\"nav navbar-nav\">                <li><img src=\"img/iiitd-logo.png\" style=\"max-width:100px;max-height:inherit;margin:7px\">                </li>                <li><a href=\"SessionDestroy\">Log Out</a>                </li>            </ul>        </div>        <div class=\"navbar-collapse collapse navbar-responsive-collapse\">            <a class=\"navbar-brand\" href=\"index.html\" style=\"font-size:30px\">PhD Admissions</a>        </div>    </div>    <div class=\"container\">        <div class=\"row\">            <div class=\"col-lg-12 col-sm-12\">                <div class=\"well\" style=\"min-height: 100%;\">    <h1 style=\"text-align: center\"> Filtered Applicants </h1>                    <table class=\"table table-striped table-hover \">                        <thead>                            <tr>                                <th>Enrollment Number</th>                                <th>Name</th>                                <th>Data</th>                                <th>Curriculum Vitae</th>                                <th>Statement of Purpose</th>                            </tr>                        </thead>                        <tbody>");
		System.out.println(new java.io.File( "." ).getCanonicalPath());
		for(Applicant a : AdminManager.getFilteredApplicants())
		{ 
			response.getWriter().println("<tr><td>" + a.getPersonalInformation().getEnrollmentNo() + "</td><td>" + a.getPersonalInformation().getApplicantName() + "</td>                                <td><a class=\"btn btn-sm btn-primary\" href=\"file://"+(new java.io.File( "." ).getCanonicalPath()).toString()+"/data/DATA" + a.getPersonalInformation().getEnrollmentNo() + "/applicantInformation.txt" + "\">DATA</a></td>                                <td><a class=\"btn btn-sm btn-primary\" href=\"file://" + a.getEducationInformation().getAchievements().getCv()  + "\">CV</a></td>                                <td><a class=\"btn btn-sm btn-primary\" href=\"file://"+ a.getEducationInformation().getAchievements().getSop() +"\">SOP</a></td>                            </tr>");
		}
		response.getWriter().println("                        </tbody>                    </table>                </div>            </div>        </div>    </div>    <script type=\"text/javascript\" src=\"https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js\"></script>    <script src=\"js/bootstrap.min.js\"></script>    <script src=\"js/material.min.js\"></script>    <script src=\"js/ripples.min.js\"></script>    <script src=\"js/gauth.js\"></script></body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
